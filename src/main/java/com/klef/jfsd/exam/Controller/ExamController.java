package com.klef.jfsd.exam.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//Display a personalized greeting message.
//URL: http://localhost:8080/SpringMVC/greet?username=Alice
//
//Render a JSP file with the name "about".
//URL: http://localhost:8080/SpringMVC/about
//
//Display age and country parameter values using a separate view (JSP file).
//URL: http://localhost:8080/SpringMVC/demo1?age=30&country=USA
//
//Perform arithmetic operations (subtraction and division) among values passed to the URL and display the result.
//URL: http://localhost:8080/SpringMVC/demo2/400/200
//
//Display a JSP file with a Product Form with input fields like Product ID, Product Name, Price, and Description.
//URL: http://localhost:8080/SpringMVC/productform
//
//Take two values through the URL, multiply them, and print the result using JSP.
//URL: http://localhost:8080/SpringMVC/multiplyNumbers?num1=6&num2=7
//
//Take two string values, reverse them, and print using JSP.
//URL: http://localhost:8080/SpringMVC/reverse?str1=Hello&str2=World
//
//Take two values via the URL, perform subtraction and addition, and print the results in JSP.
//URL: http://localhost:8080/SpringMVC/calculate?num1=20&num2=15

@Controller
public class ExamController {
	
	
	
	@RequestMapping (path = "/",method = RequestMethod.GET)	
	public ModelAndView demo()
	{
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("demo"); //demo is view name or jsp file name
		return mv;
		
	}
	@GetMapping(path="/greet")
	public ModelAndView Greet()
	{
		ModelAndView mv=new ModelAndView("greet");
		String name="Riya";
		mv.addObject("Username",name);
		return mv;
		
	}
	@GetMapping(path="/about")
	public ModelAndView About()
	{
		ModelAndView mv=new ModelAndView("about");
		return mv;
		
	}
	

	    @GetMapping("/demo1")
	    public ModelAndView displayParameters(@RequestParam("age") int age, @RequestParam("country") String country) {
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("show");
	    	mv.addObject("age" ,age );
	    	mv.addObject("country",country);
	    	
	    	return mv;
	    
	}
	    @GetMapping("demo2/{a}/{b}")
	    @ResponseBody
	    public String Addl(@PathVariable("a") int x,@PathVariable("b") int y)
	    {
	    	int z=x+y;
	    	return Integer.toString(z);
	    }
	   

	  

	        @GetMapping("/productform")
	        public ModelAndView showProductForm() {
	        	ModelAndView mv=new ModelAndView();
		    	mv.setViewName("productform");
		    	return mv;
		    	
	        }
	    

	    
	    @GetMapping("mul/{a}/{b}")
	    @ResponseBody
	    public String MUL(@PathVariable("a") int x,@PathVariable("b") int y)
	    {
	    	int z=x*y;
	    	return Integer.toString(z);
	    }
	
	    @GetMapping("calculate")
	    @ResponseBody
	    public ModelAndView Calculate(@RequestParam("a") int x,@RequestParam("b") int y)
	    {
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("calculate");
	    	int z=x+y;
	    	int z1=x-y;
	    	mv.addObject("a" ,z );
	    	mv.addObject("b",z1);
	    	return mv;
	    }

}
