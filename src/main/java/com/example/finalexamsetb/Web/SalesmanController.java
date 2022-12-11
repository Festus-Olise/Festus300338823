package com.example.finalexamsetb.Web;

import com.example.finalexamsetb.Entities.Salesman;
import com.example.finalexamsetb.Repositories.SalesmanRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class SalesmanController {

    @Autowired
    private SalesmanRepository salesmanRepository;
    static int num=0;

    @GetMapping(path = "/index")
    public String salesman(Model model) {
        List<Salesman> salesman = salesmanRepository.findAll();
        model.addAttribute("listSalesman", salesman);

        return "salesman";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        salesmanRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/editSalesman")
    public String editSalesman(Model model, Long id, HttpSession session){
        num = 2;
        session.setAttribute("info", 0);
        Salesman salesman = salesmanRepository.findById(id).orElse(null);
        if(salesman==null) throw new RuntimeException("Salesman does not exist");
        model.addAttribute("salesman", salesman);
        return "editSalesman";
    }

    @GetMapping(path = "/")
    public String salesman2(Model model, ModelMap mm,
                            @RequestParam(name="keyword",defaultValue = "") String
                                    keyword,HttpSession session){
        List<Salesman> salesman;
        if (keyword.isEmpty()) {
            salesman = salesmanRepository.findAll();
        } else {
            mm.put("e", 0);
            mm.put("a", 0);
            long key = Long.parseLong(keyword);
            salesman = salesmanRepository.findSalesmanById(key);
        }
        model.addAttribute("listSalesman", salesman);
        return "salesman";
    }

}
