package guru.springframework.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.ImmutableMap;

import guru.springframework.domain.CheckoutCommand;

@Controller
public class CheckoutController {

    @RequestMapping("/checkout")
    public String checkoutForm(){
        return "checkoutform";
    }
    
    @RequestMapping(value = "/checkoutcomplete")
    public String checkoutComplete(){
    	return "checkoutcomplete";
    }
    
    @RequestMapping(value = "/docheckout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> doCheckout(@RequestBody @Valid CheckoutCommand checkoutCommand, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(ImmutableMap.of("data", bindingResult.getAllErrors()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(ImmutableMap.of("data","checkoutcomplete"), HttpStatus.OK);
    }
}


