package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("goodbye", "Tam biet");
        dictionary.put("dictionary", "Tu dien");
        dictionary.put("currency", "Tien te");
        dictionary.put("food", "Thuc an");
        dictionary.put("sleep", "Ngu");
    }

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String word, Model model) {
        String meaning = dictionary.get(word);
        model.addAttribute("meaning", meaning);
        return "result";
    }
}
