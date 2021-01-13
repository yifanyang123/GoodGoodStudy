%% =============================================================================
%%
%%  CONCORDIA UNIVERSITY
%%  Department of Computer Science and Software Engineering
%%  SOEN 331-W:  Assingment 1
%%  Winter term, 2019
%%  Date submitted: February 11, 2019
%%
%%  Authors: 
%%
%%  Yifan Yang,40038814,pigooo1@Hotmail.com
%%  indifidual,no group
%%  
%%
%% =============================================================================

%% =============================================================================
%%
%%  Facts
%%
%% =============================================================================


state(idle).
state(monitoring1).
state(monitoring2).
state(warming).
state(on).
state(configuration).
state(empty).
state(entering).
state(finish).
superstate(idle,monitoring1).
superstate(warming,monitoring2).
superstate(warming,on).
superstate(configuration,empty).
superstate(configuration,entering).
superstate(configuration,finish).
initialstate(idle,null).
initialstate(warming,idle).
initialstate(configuration,idle).
initialstate(configuration,warming).
initialstate(monitoring2,on).
initialstate(entering,empty).
initialstate(empty,null).
initialstate(on,null).
initialstate(monitoring1,null).
initialstate(finishing,entering).
transition(null,idle,null,null,'warm_start=false,warm_ok=false,warm_interrupt=false').
transition(idle,configuration,'set-button pressed',null,'beep,switch led lgiht on,active timer').
transition(configuration,idle,null,null,'triplet=null,deactivate timer,switch led light off').
transition(monitoring1,monitoring1,'after 2min,','ct is not in the time interval of one triplet in triplet set','ct=current time').
transition(monitoring1,monitoring1,'after 2min,','ct is in the time interval of one triplet in triplet set,cet=>dt-1','ct=current time,dt=desired temperature,cet=current environment temperature').



%% =============================================================================
%%
%%  Rules
%%
%% =============================================================================
ancestor(X,Y):-transition(Y,X,_,_,_).
get_all_transition:-forall(transition(A,B,C,_,E),format("( ~w,~w,~w,~w)\n", [A,B,C,E])).
get_inherited_transitions(A, L) :- transition(X,A ,_,_,_),get_inherited_transitions(null,X).

%% eof.