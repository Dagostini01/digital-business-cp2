package checkpoint.controllers;

import checkpoint.services.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pix")
public class PixController {

    @Autowired
    private PixService pixService;


}
