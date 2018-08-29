package cib.se.adv.lambda_practice.p08;

/**
 *
 * @author oracle
 */
public enum State {    
    CA("CA"),
    CO("CO"),
    MA("MA");
    
    private final String str;
    
    State(String stateStr){
        this.str = stateStr;
    }
    
    public String getStr(){
        return str;
    }        
   
}
