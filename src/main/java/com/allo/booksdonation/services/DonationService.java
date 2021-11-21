package com.allo.booksdonation.services;

import com.allo.booksdonation.dtos.ContentsDonationsDTO;
import com.allo.booksdonation.dtos.DonationDTO;
import com.allo.booksdonation.dtos.FilterDonationsDTO;
import com.allo.booksdonation.entities.Book;
import com.allo.booksdonation.entities.BookInfo;
import com.allo.booksdonation.entities.Donation;
import com.allo.booksdonation.entities.enums.DonateStatus;
import com.allo.booksdonation.exceptions.ObjectNotFoundException;
import com.allo.booksdonation.mappers.*;
import com.allo.booksdonation.repositories.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DonationService {

    private static final String ID = "id";
    private static final String BOOK_ID = "bookId";
    private static final String BOOK_INFO_ID = "bookInfoId";
    private static final String VOLUME_INFO = "volumeInfo";
    private static final String TITLE = "title";
    private static final String PUBLISHER = "publisher";
    private static final String PUBLISHER_DATE = "publishedDate";
    private static final String DESCRIPTION = "description";
    private static final String PREVIEW_LINK = "previewLink";
    private static final String INFO_LINK = "infoLink";
    private static final String CANONICAL_VOLUME_LINK = "canonicalVolumeLink";
    private static final String TEXT_SNIPPET = "textSnippet";
    private static final String AUTHORS = "authors";
    private static final String CATEGORIES = "categories";

    private final DonationRepository repository;
    private final DonationMapper donationMapper;

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public DonationDTO createDonation(DonationDTO dto) {
        Donation donation = donationMapper.toEntity(dto);
        donation.setLastDateUpdated(Instant.now());

        donation.setStatus(DonateStatus.ACTIVE);
        donation.setId(null);

        return donationMapper.toDto(repository.save(donation));
    }

    @Transactional
    public DonationDTO updateDonation(DonationDTO dto) {
        Donation donation = donationMapper.toEntity(dto);
        donation.setLastDateUpdated(Instant.now());

        donation.setStatus(DonateStatus.ACTIVE);

        return donationMapper.toDto(repository.save(donation));

    }

    public DonateStatus changeStatus(Long idDonation, String status) {
        Donation donation = repository.findById(idDonation).orElseThrow(() -> new ObjectNotFoundException("Donation not found."));

        UserSecurityService.verificaUsuarioLogado(donation.getUser().getId());

        donation.setStatus(DonateStatus.valueOf(status));
        repository.save(donation);
        return donation.getStatus();
    }

    public DonationDTO findADonarion(Long idDonation) {
        Donation donation = repository.findById(idDonation).orElseThrow(() -> new ObjectNotFoundException("Donation not found"));
        return donationMapper.toDto(donation);
    }

    public Page<ContentsDonationsDTO> findByBook(FilterDonationsDTO dto, PageRequest pageRequest) {
        return specFindByBook(dto, pageRequest);
    }

    public Page<ContentsDonationsDTO> specFindByBook(FilterDonationsDTO dto, PageRequest pageable){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContentsDonationsDTO> criteria = builder.createQuery(ContentsDonationsDTO.class);

        Root<Book> root = criteria.from(Book.class);
        Join<Book, BookInfo> joinBook = root.join(VOLUME_INFO, JoinType.LEFT);
        joinBook.on(builder.equal(root.get(BOOK_ID), joinBook.get(ID)));

        List<Predicate> predicates = defautDonationPredicates(dto, builder, joinBook);

        criteria
            .multiselect(
                root.get(BOOK_ID).alias(BOOK_ID),
                joinBook.get(ID).alias(BOOK_INFO_ID),
                joinBook.get(TITLE).alias(TITLE),
                joinBook.get(PUBLISHER).alias(PUBLISHER),
                joinBook.get(PUBLISHER_DATE).alias(PUBLISHER_DATE),
                joinBook.get(DESCRIPTION).alias(DESCRIPTION),
                joinBook.get(PREVIEW_LINK).alias(PREVIEW_LINK),
                joinBook.get(INFO_LINK).alias(INFO_LINK),
                joinBook.get(CANONICAL_VOLUME_LINK).alias(CANONICAL_VOLUME_LINK),
                joinBook.get(TEXT_SNIPPET).alias(TEXT_SNIPPET),
                joinBook.join(AUTHORS),
                joinBook.join(CATEGORIES)
            )
            .where(predicates.toArray(new Predicate[0]));

        List<ContentsDonationsDTO> result = manager.createQuery(criteria).setFirstResult((int)
                pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

        return new PageImpl<>(result, pageable, result.stream().count());
    }

    public List<Predicate> defautDonationPredicates(
            FilterDonationsDTO dto,
            CriteriaBuilder builder,
            Join<Book,
            BookInfo> joinBook){
        List<Predicate> predicates = new ArrayList<>();

        if(dto.getTitle() != null) predicates.add(builder.like(joinBook.get(TITLE), dto.getTitle() + "%"));
        if(dto.getCategories() != null) predicates.add(builder.like(joinBook.join(CATEGORIES), dto.getCategories()  + "%"));
        if(dto.getAuthor() != null) predicates.add(builder.like(joinBook.join(AUTHORS), dto.getAuthor()  + "%"));

        return predicates;
    }
}
