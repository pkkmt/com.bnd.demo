package com.bnd.demo.eval.provider;


import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

import com.bnd.demo.eval.api.Eval;

import osgi.enroute.debug.api.Debug;
import parsii.eval.Parser;

/**
 * 
 */
@Component(name = "com.bnd.demo.eval",
property = {
		Debug.COMMAND_SCOPE + "=test", 
		Debug.COMMAND_FUNCTION + "=eval" 
	}
)
public class EvalImpl implements Eval {
Pattern EXPR = Pattern.compile( "\\s*(?<left>\\d+)\\s*(?<op>\\+|-)\\s*(?<right>\\d+)\\s*");
	
@Override
public double eval(String expression) throws Exception {
	return Parser.parse(expression).evaluate();
}
}
 