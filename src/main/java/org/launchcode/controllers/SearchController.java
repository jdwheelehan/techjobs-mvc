package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }




    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String searchresults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        model.addAttribute("columns", ListController.columnChoices);
        ArrayList jobs;

        if (searchType.equals("all")){
            jobs = JobData.findByValue(searchTerm);


        }else{
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);

        }
        String jobSize = jobs.size() + " Results";
        model.addAttribute("jobs", jobs);
        model.addAttribute("jobSize", jobSize);


        return "search";
    }
    //@RequestParam searchType, @RequestParam searchTerm)


}
