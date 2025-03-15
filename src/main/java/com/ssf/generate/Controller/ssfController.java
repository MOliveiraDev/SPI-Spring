package com.ssf.generate.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.ssf.generate.Model.ssfModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.ssf.generate.Repository.ssfRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Controller
@RequestMapping("/usuario")
public class ssfController {

    @Autowired
    private ssfRepository ssfRepository;

    public ssfModel gerarUsuários(ssfModel ssfModel) {
        return ssfRepository.save(ssfModel);
    }
}
