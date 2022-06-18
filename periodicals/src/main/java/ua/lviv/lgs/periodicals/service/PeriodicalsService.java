package ua.lviv.lgs.periodicals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.periodicals.controller.PeriodicalsController;
import ua.lviv.lgs.periodicals.dao.PeriodicalRepository;
import ua.lviv.lgs.periodicals.domain.Periodical;

import java.util.List;

@Service
public class PeriodicalsService {
    @Autowired
    private PeriodicalRepository periodicalRepository;

    public Periodical save(Periodical periodical) {
        return periodicalRepository.save(periodical);
    }

    public List<Periodical> getAllPeriodicals() {
        return periodicalRepository.findAll();
    }
}
