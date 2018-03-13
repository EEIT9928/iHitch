package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path={"/switch"})
public class SwitchPages {
	@RequestMapping(path= {"/switchPswd.controller"},method= {RequestMethod.GET})
	public String switchChgPswd() {
		return "chgPswd";
	}
	@RequestMapping(path= {"/switchPref.controller"},method= {RequestMethod.GET})
	public String switchPref() {
		return "editPref";
	}
    @RequestMapping(path= {"/switchLogin.controller"},method= {RequestMethod.GET})
    public String switchLogin() {
    	return "login";
    }
    @RequestMapping(path= {"/switchEditCars.controller"},method= {RequestMethod.GET})
    public String switchEditCars() {
    	return "editCars";
    }
    @RequestMapping(path= {"/switchEditProf.controller"},method= {RequestMethod.GET})
    public String switchEditProf() {
    	return "editProfile";
    }
    @RequestMapping(path= {"/switchVerification.controller"},method= {RequestMethod.GET})
    public String switchVerification() {
    	return "verification";
    }
    
}
