package ua.lviv.lgs.periodicals.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.periodicals.dao.BucketRepository;
import ua.lviv.lgs.periodicals.domain.Bucket;

import java.util.List;

@Service
public class BucketService {
    Logger logger = LoggerFactory.getLogger(BucketService.class);

    @Autowired
    private BucketRepository bucketRepository;

    public List<Bucket> getAll() {
        logger.debug("Get all buckets items");
        return bucketRepository.findAll();
    }

    public void delete(Bucket bucket) {
        logger.debug("Delete bucket item {} : " + bucket);
        bucketRepository.delete(bucket);
    }

    public Bucket add (Bucket bucket) {
        logger.debug("Create new bucket item {} : "+ bucket);
        return bucketRepository.save(bucket);
    }
}
