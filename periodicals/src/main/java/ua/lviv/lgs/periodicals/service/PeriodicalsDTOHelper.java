package ua.lviv.lgs.periodicals.service;

import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.lviv.lgs.periodicals.domain.Periodical;

import java.io.IOException;
import java.util.Base64;

public class PeriodicalsDTOHelper {

    public static Periodical createEntity ( MultipartFile file, String name, String description, Double price) throws IOException {


        Periodical periodical = new Periodical();
        periodical.setName(name);
        periodical.setDescription(description);
        periodical.setPrice(price);
        periodical.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return periodical;
    }
}
