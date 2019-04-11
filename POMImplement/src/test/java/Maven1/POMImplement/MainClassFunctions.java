package Maven1.POMImplement;




import SanityTestCasesExecution.SanityTests;
import SmokeTestCasesExecution.SmokeTests;
public class MainClassFunctions {

	public void main() throws Exception {
		// TODO Auto-generated method stub
    SanityTests st=new SanityTests();
    SmokeTests smt=new   SmokeTests();
    st.TC3();
    st.TC4();
    st.TC5();
    smt.TC1();
    smt.TC2();
    
	}

}
