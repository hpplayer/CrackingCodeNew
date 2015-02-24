package Chapter8_2_sol2;

import java.util.ArrayList;
import java.util.List;


public class CallHandler {
	private static CallHandler instance;
	
	private final int LEVELS = 3; //3 layer of employee
	
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;
	
	List<List<Employee>> employeeLevels;//matrix
	List<List<Call>> callQueues;//matrix x2 
	protected CallHandler(){
		employeeLevels = new ArrayList<List<Employee>>(LEVELS);
		callQueues = new ArrayList<List<Call>>(LEVELS);
		
		//create respodents
		ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDENTS);
		for (int i = 0; i < NUM_RESPONDENTS; i++){//? NUM -1?
			respondents.add(new Respondent());
		}
		employeeLevels.add(respondents);
		
		//create managers
		ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
		managers.add(new Manager());
		employeeLevels.add(managers);
		
		//create directors
		ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
		directors.add(new director());
		employeeLevels.add(directors);
	}
	
	/*singleton class */
	public static CallHandler getInstance(){
		if(instance == null){
			instance = new CallHandler();
		}
		return instance;
	}
	
	/*
	 * retrieve emp using naive method,
	 * recusively search all employee layer by layer 
	 * return the free one (if the call needs help? thats ok, since the starting level
	 * is determined eariler, the search begin after that level)
	 */
	public Employee getHandlerForCall(Call call){
		for (int level = call.getRank().getValue(); level < LEVELS; level++){//why level - 1?
			List<Employee> employeeLevel = employeeLevels.get(level);//retrieve level of employee
			for (Employee emp: employeeLevel){
				if(emp.isFree()){
					return emp;//if found any emp available
				}
			}
		}
		return null;//cant find emp available
	}
	
	/*either initialize the call with caller or without it */
	/*
	public void dispatchCall(Caller caller){
		Call call = new Call(caller);
		dispatchCall(call);
	}
	*/
	
	public void dispatchCall(Call call){
		Employee emp = getHandlerForCall(call);
		if(emp != null){
			emp.receiveCall(call);
			call.setHandler(emp);
		}else{//if cant find emp available
			call.reply("please wait a moment");
			callQueues.get(call.getRank().getValue()).add(call);//get the corresponding call level then enqueue
		}
	}
	
	public boolean assignCall(Employee emp){
		for (int rank = emp.getRank().getValue(); rank >= 0; rank--){
			List<Call> que = callQueues.get(rank); //get call queue in corresponding level
			
			if(que.size() > 0){
				Call call = que.remove(0);
				if(call != null){
					emp.receiveCall(call);
					return true;
				}
			}
		}
		return false;
	}

	
}
