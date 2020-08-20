package controller;

import model.Dependency.DungSiThongThai;
import model.Dependency.NhiemVu;
import model.NoDependency.DungSiDepTrai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DungSiDepTraiController {

    @GetMapping("/dungsideptrai")
    public String DungSiHanhDong(ModelMap model) {
        DungSiDepTrai dungSiDepTrai = new DungSiDepTrai();
        String ketqua = dungSiDepTrai.thucHienNhiemVu();
        model.addAttribute("ketqua",ketqua);
        return "DungSiDepTrai";
    }
}
