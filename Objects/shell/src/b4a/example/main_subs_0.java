package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,46);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 48;BA.debugLine="init";
Debug.ShouldStop(32768);
_init();
 BA.debugLineNum = 52;BA.debugLine="userInp.Text = 0";
Debug.ShouldStop(524288);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 53;BA.debugLine="result.Text = 0";
Debug.ShouldStop(1048576);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(0));
 BA.debugLineNum = 56;BA.debugLine="declareList";
Debug.ShouldStop(8388608);
_declarelist();
 BA.debugLineNum = 59;BA.debugLine="changeText";
Debug.ShouldStop(67108864);
_changetext();
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,66);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 62;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _backimage_click() throws Exception{
try {
		Debug.PushSubsStack("backImage_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,269);
if (RapidSub.canDelegate("backimage_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","backimage_click");}
 BA.debugLineNum = 269;BA.debugLine="Private Sub backImage_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 272;BA.debugLine="mainFrame.Visible = False";
Debug.ShouldStop(32768);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 273;BA.debugLine="startFrame.Visible = True";
Debug.ShouldStop(65536);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 275;BA.debugLine="userInp.Text = \"0\"";
Debug.ShouldStop(262144);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 276;BA.debugLine="result.Text = \"0\"";
Debug.ShouldStop(524288);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 277;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _backspace_click() throws Exception{
try {
		Debug.PushSubsStack("backspace_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,369);
if (RapidSub.canDelegate("backspace_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","backspace_click");}
RemoteObject _usr = RemoteObject.createImmutable("");
 BA.debugLineNum = 369;BA.debugLine="Private Sub backspace_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 370;BA.debugLine="If first = True Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",main._first,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 371;BA.debugLine="If userInp.Text = \".\" Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main.mostCurrent._userinp.runMethod(true,"getText"),BA.ObjectToString("."))) { 
 BA.debugLineNum = 372;BA.debugLine="userInp.Text = \"0\"";
Debug.ShouldStop(524288);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 373;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 375;BA.debugLine="If userInp.Text = 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main.mostCurrent._userinp.runMethod(true,"getText"),BA.NumberToString(0))) { 
 BA.debugLineNum = 376;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 378;BA.debugLine="Dim usr As String = userInp.Text.Replace(\",\",\"\")";
Debug.ShouldStop(33554432);
_usr = main.mostCurrent._userinp.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("usr", _usr);Debug.locals.put("usr", _usr);
 BA.debugLineNum = 379;BA.debugLine="If usr.Length > 1 Then 'checks if there is text";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",_usr.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 380;BA.debugLine="usr = usr.SubString2(0, usr.Length -1) 'removes";
Debug.ShouldStop(134217728);
_usr = _usr.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usr.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("usr", _usr);
 }else {
 BA.debugLineNum = 383;BA.debugLine="usr = \"0\" 'if deleted it will turn into 0";
Debug.ShouldStop(1073741824);
_usr = BA.ObjectToString("0");Debug.locals.put("usr", _usr);
 };
 BA.debugLineNum = 386;BA.debugLine="userInp.Text = NumberFormat(usr,1,10)";
Debug.ShouldStop(2);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _usr)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 388;BA.debugLine="convert";
Debug.ShouldStop(8);
_convert();
 }else {
 BA.debugLineNum = 390;BA.debugLine="If result.Text = \".\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent._result.runMethod(true,"getText"),BA.ObjectToString("."))) { 
 BA.debugLineNum = 391;BA.debugLine="result.Text = \"0\"";
Debug.ShouldStop(64);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 392;BA.debugLine="Return";
Debug.ShouldStop(128);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 394;BA.debugLine="If result.Text = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent._result.runMethod(true,"getText"),BA.NumberToString(0))) { 
 BA.debugLineNum = 395;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 397;BA.debugLine="Dim usr As String = result.Text.Replace(\",\",\"\")";
Debug.ShouldStop(4096);
_usr = main.mostCurrent._result.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("usr", _usr);Debug.locals.put("usr", _usr);
 BA.debugLineNum = 398;BA.debugLine="If usr.Length > 1 Then 'checks if there is text";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean(">",_usr.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 399;BA.debugLine="usr = usr.SubString2(0, usr.Length -1) 'removes";
Debug.ShouldStop(16384);
_usr = _usr.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usr.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("usr", _usr);
 }else {
 BA.debugLineNum = 402;BA.debugLine="usr = \"0\" 'if deleted it will turn into 0";
Debug.ShouldStop(131072);
_usr = BA.ObjectToString("0");Debug.locals.put("usr", _usr);
 };
 BA.debugLineNum = 405;BA.debugLine="result.Text = NumberFormat(usr,1,10)";
Debug.ShouldStop(1048576);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _usr)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)))));
 BA.debugLineNum = 407;BA.debugLine="convert";
Debug.ShouldStop(4194304);
_convert();
 };
 BA.debugLineNum = 409;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button0_click() throws Exception{
try {
		Debug.PushSubsStack("Button0_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,426);
if (RapidSub.canDelegate("button0_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button0_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 426;BA.debugLine="Private Sub Button0_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 427;BA.debugLine="Dim const number As String = \"0\"";
Debug.ShouldStop(1024);
_number = BA.ObjectToString("0");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 428;BA.debugLine="input(number)";
Debug.ShouldStop(2048);
_input(_number);
 BA.debugLineNum = 429;BA.debugLine="convert";
Debug.ShouldStop(4096);
_convert();
 BA.debugLineNum = 430;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button1_click() throws Exception{
try {
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,432);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 432;BA.debugLine="Private Sub Button1_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 433;BA.debugLine="Dim const number As String = \"1\"";
Debug.ShouldStop(65536);
_number = BA.ObjectToString("1");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 434;BA.debugLine="input(number)";
Debug.ShouldStop(131072);
_input(_number);
 BA.debugLineNum = 435;BA.debugLine="convert";
Debug.ShouldStop(262144);
_convert();
 BA.debugLineNum = 436;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button2_click() throws Exception{
try {
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,438);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button2_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 438;BA.debugLine="Private Sub Button2_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 439;BA.debugLine="Dim const number As String = \"2\"";
Debug.ShouldStop(4194304);
_number = BA.ObjectToString("2");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 440;BA.debugLine="input(number)";
Debug.ShouldStop(8388608);
_input(_number);
 BA.debugLineNum = 441;BA.debugLine="convert";
Debug.ShouldStop(16777216);
_convert();
 BA.debugLineNum = 442;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button3_click() throws Exception{
try {
		Debug.PushSubsStack("Button3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,444);
if (RapidSub.canDelegate("button3_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button3_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 444;BA.debugLine="Private Sub Button3_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 445;BA.debugLine="Dim const number As String = \"3\"";
Debug.ShouldStop(268435456);
_number = BA.ObjectToString("3");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 446;BA.debugLine="input(number)";
Debug.ShouldStop(536870912);
_input(_number);
 BA.debugLineNum = 447;BA.debugLine="convert";
Debug.ShouldStop(1073741824);
_convert();
 BA.debugLineNum = 448;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button4_click() throws Exception{
try {
		Debug.PushSubsStack("Button4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,450);
if (RapidSub.canDelegate("button4_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button4_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 450;BA.debugLine="Private Sub Button4_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 451;BA.debugLine="Dim const number As String = \"4\"";
Debug.ShouldStop(4);
_number = BA.ObjectToString("4");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 452;BA.debugLine="input(number)";
Debug.ShouldStop(8);
_input(_number);
 BA.debugLineNum = 453;BA.debugLine="convert";
Debug.ShouldStop(16);
_convert();
 BA.debugLineNum = 454;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button5_click() throws Exception{
try {
		Debug.PushSubsStack("Button5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,456);
if (RapidSub.canDelegate("button5_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button5_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 456;BA.debugLine="Private Sub Button5_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 457;BA.debugLine="Dim const number As String = \"5\"";
Debug.ShouldStop(256);
_number = BA.ObjectToString("5");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 458;BA.debugLine="input(number)";
Debug.ShouldStop(512);
_input(_number);
 BA.debugLineNum = 459;BA.debugLine="convert";
Debug.ShouldStop(1024);
_convert();
 BA.debugLineNum = 460;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button6_click() throws Exception{
try {
		Debug.PushSubsStack("Button6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,462);
if (RapidSub.canDelegate("button6_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button6_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 462;BA.debugLine="Private Sub Button6_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 463;BA.debugLine="Dim const number As String = \"6\"";
Debug.ShouldStop(16384);
_number = BA.ObjectToString("6");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 464;BA.debugLine="input(number)";
Debug.ShouldStop(32768);
_input(_number);
 BA.debugLineNum = 465;BA.debugLine="convert";
Debug.ShouldStop(65536);
_convert();
 BA.debugLineNum = 466;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button7_click() throws Exception{
try {
		Debug.PushSubsStack("Button7_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,468);
if (RapidSub.canDelegate("button7_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button7_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 468;BA.debugLine="Private Sub Button7_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 469;BA.debugLine="Dim const number As String = \"7\"";
Debug.ShouldStop(1048576);
_number = BA.ObjectToString("7");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 470;BA.debugLine="input(number)";
Debug.ShouldStop(2097152);
_input(_number);
 BA.debugLineNum = 471;BA.debugLine="convert";
Debug.ShouldStop(4194304);
_convert();
 BA.debugLineNum = 472;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button8_click() throws Exception{
try {
		Debug.PushSubsStack("Button8_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,474);
if (RapidSub.canDelegate("button8_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button8_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 474;BA.debugLine="Private Sub Button8_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 475;BA.debugLine="Dim const number As String = \"8\"";
Debug.ShouldStop(67108864);
_number = BA.ObjectToString("8");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 476;BA.debugLine="input(number)";
Debug.ShouldStop(134217728);
_input(_number);
 BA.debugLineNum = 477;BA.debugLine="convert";
Debug.ShouldStop(268435456);
_convert();
 BA.debugLineNum = 478;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _button9_click() throws Exception{
try {
		Debug.PushSubsStack("Button9_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,480);
if (RapidSub.canDelegate("button9_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button9_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 480;BA.debugLine="Private Sub Button9_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 481;BA.debugLine="Dim const number As String = \"9\"";
Debug.ShouldStop(1);
_number = BA.ObjectToString("9");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 482;BA.debugLine="input(number)";
Debug.ShouldStop(2);
_input(_number);
 BA.debugLineNum = 483;BA.debugLine="convert";
Debug.ShouldStop(4);
_convert();
 BA.debugLineNum = 484;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttonclear_click() throws Exception{
try {
		Debug.PushSubsStack("Buttonclear_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,361);
if (RapidSub.canDelegate("buttonclear_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonclear_click");}
 BA.debugLineNum = 361;BA.debugLine="Private Sub Buttonclear_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 363;BA.debugLine="userInp.Text = \"0\"";
Debug.ShouldStop(1024);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 364;BA.debugLine="result.Text = \"0\"";
Debug.ShouldStop(2048);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 365;BA.debugLine="convert";
Debug.ShouldStop(4096);
_convert();
 BA.debugLineNum = 366;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buttondot_click() throws Exception{
try {
		Debug.PushSubsStack("Buttondot_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,355);
if (RapidSub.canDelegate("buttondot_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttondot_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 355;BA.debugLine="Private Sub Buttondot_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 356;BA.debugLine="Dim number As String = \".\" 'adds a dot";
Debug.ShouldStop(8);
_number = BA.ObjectToString(".");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 357;BA.debugLine="input(number)";
Debug.ShouldStop(16);
_input(_number);
 BA.debugLineNum = 358;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _changetext() throws Exception{
try {
		Debug.PushSubsStack("changeText (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("changetext")) { return b4a.example.main.remoteMe.runUserSub(false, "main","changetext");}
 BA.debugLineNum = 70;BA.debugLine="Sub changeText";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="If first Then";
Debug.ShouldStop(64);
if (main._first.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 72;BA.debugLine="userInp.TextColor = Colors.RGB(0,0,255)";
Debug.ShouldStop(128);
main.mostCurrent._userinp.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 73;BA.debugLine="userInp.TextSize = 25";
Debug.ShouldStop(256);
main.mostCurrent._userinp.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 BA.debugLineNum = 74;BA.debugLine="result.TextColor = Colors.RGB(0,0,0)";
Debug.ShouldStop(512);
main.mostCurrent._result.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 75;BA.debugLine="result.TextSize = 17";
Debug.ShouldStop(1024);
main.mostCurrent._result.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 }else 
{ BA.debugLineNum = 76;BA.debugLine="Else If second Then";
Debug.ShouldStop(2048);
if (main._second.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 77;BA.debugLine="userInp.TextColor = Colors.RGB(0,0,0)";
Debug.ShouldStop(4096);
main.mostCurrent._userinp.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 78;BA.debugLine="userInp.TextSize = 17";
Debug.ShouldStop(8192);
main.mostCurrent._userinp.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 BA.debugLineNum = 79;BA.debugLine="result.TextColor = Colors.RGB(0,0,255)";
Debug.ShouldStop(16384);
main.mostCurrent._result.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 80;BA.debugLine="result.TextSize = 25";
Debug.ShouldStop(32768);
main.mostCurrent._result.runMethod(true,"setTextSize",BA.numberCast(float.class, 25));
 }}
;
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _checkhigh(RemoteObject _usr) throws Exception{
try {
		Debug.PushSubsStack("checkhigh (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,279);
if (RapidSub.canDelegate("checkhigh")) { return b4a.example.main.remoteMe.runUserSub(false, "main","checkhigh", _usr);}
Debug.locals.put("usr", _usr);
 BA.debugLineNum = 279;BA.debugLine="Sub checkhigh(usr As String) As Boolean";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 280;BA.debugLine="If usr > 2000000000 Or usr < -2000000000 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, _usr),BA.numberCast(double.class, 2000000000)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, _usr),BA.numberCast(double.class, -(double) (0 + 2000000000)))) { 
 BA.debugLineNum = 281;BA.debugLine="ToastMessageShow(\"input/output is too high\", Fal";
Debug.ShouldStop(16777216);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("input/output is too high")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 282;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
if (true) return main.mostCurrent.__c.getField(true,"True");
 };
 BA.debugLineNum = 284;BA.debugLine="If first = True Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main._first,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 285;BA.debugLine="If userInp.Text.Replace(\",\",\"\") > 2000000000 Or";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._userinp.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))),BA.numberCast(double.class, 2000000000)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._userinp.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))),BA.numberCast(double.class, -(double) (0 + 2000000000)))) { 
 BA.debugLineNum = 286;BA.debugLine="ToastMessageShow(\"input/output is too high\", Fa";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("input/output is too high")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 287;BA.debugLine="Return True";
Debug.ShouldStop(1073741824);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }else 
{ BA.debugLineNum = 288;BA.debugLine="Else if result.Text.Replace(\",\",\"\") > 2000000000";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",BA.numberCast(double.class, main.mostCurrent._result.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))),BA.numberCast(double.class, 2000000000)) || RemoteObject.solveBoolean("<",BA.numberCast(double.class, main.mostCurrent._result.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))),BA.numberCast(double.class, -(double) (0 + 2000000000)))) { 
 BA.debugLineNum = 289;BA.debugLine="ToastMessageShow(\"input/output is too high\", Fa";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("input/output is too high")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 290;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return main.mostCurrent.__c.getField(true,"True");
 }}
;
 };
 BA.debugLineNum = 293;BA.debugLine="Return False";
Debug.ShouldStop(16);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 294;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _coin_click() throws Exception{
try {
		Debug.PushSubsStack("coin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,206);
if (RapidSub.canDelegate("coin_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","coin_click");}
 BA.debugLineNum = 206;BA.debugLine="Private Sub coin_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="coinClick = True";
Debug.ShouldStop(16384);
main._coinclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 208;BA.debugLine="weightClick = False";
Debug.ShouldStop(32768);
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 209;BA.debugLine="lengthClick = False";
Debug.ShouldStop(65536);
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 210;BA.debugLine="transferMain";
Debug.ShouldStop(131072);
_transfermain();
 BA.debugLineNum = 211;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convert() throws Exception{
try {
		Debug.PushSubsStack("convert (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,415);
if (RapidSub.canDelegate("convert")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convert");}
 BA.debugLineNum = 415;BA.debugLine="Sub convert";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 417;BA.debugLine="If coinClick = True Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main._coinclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 418;BA.debugLine="convertMoney";
Debug.ShouldStop(2);
_convertmoney();
 }else 
{ BA.debugLineNum = 419;BA.debugLine="else if weightClick = True Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main._weightclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 420;BA.debugLine="convertMass";
Debug.ShouldStop(8);
_convertmass();
 }else 
{ BA.debugLineNum = 421;BA.debugLine="else if lengthClick = True Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main._lengthclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 422;BA.debugLine="convertDist";
Debug.ShouldStop(32);
_convertdist();
 }}}
;
 BA.debugLineNum = 424;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertdist() throws Exception{
try {
		Debug.PushSubsStack("convertDist (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,160);
if (RapidSub.canDelegate("convertdist")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertdist");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 160;BA.debugLine="Sub convertDist";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 162;BA.debugLine="Dim from As String";
Debug.ShouldStop(2);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 163;BA.debugLine="from = distBef.SelectedItem";
Debug.ShouldStop(4);
_from = main.mostCurrent._distbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 165;BA.debugLine="Dim into As String";
Debug.ShouldStop(16);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 166;BA.debugLine="into = distAf.SelectedItem";
Debug.ShouldStop(32);
_into = main.mostCurrent._distaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 168;BA.debugLine="Dim distance As Map";
Debug.ShouldStop(128);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 169;BA.debugLine="distance.Initialize";
Debug.ShouldStop(256);
_distance.runVoidMethod ("Initialize");
 BA.debugLineNum = 171;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
Debug.ShouldStop(1024);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilometer"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 172;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
Debug.ShouldStop(2048);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("centimeter"))),(Object)(RemoteObject.createImmutable((100.00))));
 BA.debugLineNum = 173;BA.debugLine="distance.Put(\"meter\", 1.00)";
Debug.ShouldStop(4096);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("meter"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 174;BA.debugLine="distance.Put(\"foot\", 3.28084)";
Debug.ShouldStop(8192);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("foot"))),(Object)(RemoteObject.createImmutable((3.28084))));
 BA.debugLineNum = 176;BA.debugLine="mainConvert(distance.Get(from), distance.Get(into";
Debug.ShouldStop(32768);
_mainconvert(BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_into)))));
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertmass() throws Exception{
try {
		Debug.PushSubsStack("convertMass (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,139);
if (RapidSub.canDelegate("convertmass")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmass");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 139;BA.debugLine="Sub convertMass";
Debug.ShouldStop(1024);
 BA.debugLineNum = 141;BA.debugLine="Dim from As String";
Debug.ShouldStop(4096);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 142;BA.debugLine="from = massBef.SelectedItem";
Debug.ShouldStop(8192);
_from = main.mostCurrent._massbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 144;BA.debugLine="Dim into As String";
Debug.ShouldStop(32768);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 145;BA.debugLine="into = massAf.SelectedItem";
Debug.ShouldStop(65536);
_into = main.mostCurrent._massaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 147;BA.debugLine="Dim mass As Map";
Debug.ShouldStop(262144);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 148;BA.debugLine="mass.Initialize";
Debug.ShouldStop(524288);
_mass.runVoidMethod ("Initialize");
 BA.debugLineNum = 152;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
Debug.ShouldStop(8388608);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilogram"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 153;BA.debugLine="mass.Put(\"gram\", 1.00)";
Debug.ShouldStop(16777216);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("gram"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 154;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
Debug.ShouldStop(33554432);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("pound"))),(Object)(RemoteObject.createImmutable((0.00220462))));
 BA.debugLineNum = 156;BA.debugLine="mainConvert(mass.Get(from), mass.Get(into))";
Debug.ShouldStop(134217728);
_mainconvert(BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_into)))));
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertmoney() throws Exception{
try {
		Debug.PushSubsStack("convertMoney (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("convertmoney")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmoney");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _dollarmoney = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 116;BA.debugLine="Sub convertMoney";
Debug.ShouldStop(524288);
 BA.debugLineNum = 118;BA.debugLine="Dim from As String";
Debug.ShouldStop(2097152);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 119;BA.debugLine="from = moneyBef.SelectedItem 'get selected item";
Debug.ShouldStop(4194304);
_from = main.mostCurrent._moneybef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 121;BA.debugLine="Dim into As String";
Debug.ShouldStop(16777216);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 122;BA.debugLine="into = moneyAf.SelectedItem";
Debug.ShouldStop(33554432);
_into = main.mostCurrent._moneyaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 124;BA.debugLine="Dim dollarMoney As Map";
Debug.ShouldStop(134217728);
_dollarmoney = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("dollarMoney", _dollarmoney);
 BA.debugLineNum = 125;BA.debugLine="dollarMoney.Initialize";
Debug.ShouldStop(268435456);
_dollarmoney.runVoidMethod ("Initialize");
 BA.debugLineNum = 129;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
Debug.ShouldStop(1);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("PHP"))),(Object)(RemoteObject.createImmutable((54.91))));
 BA.debugLineNum = 130;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
Debug.ShouldStop(2);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("US Dollar"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 131;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
Debug.ShouldStop(4);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Yuan"))),(Object)(RemoteObject.createImmutable((6.90))));
 BA.debugLineNum = 132;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
Debug.ShouldStop(8);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Ruble"))),(Object)(RemoteObject.createImmutable((76.26))));
 BA.debugLineNum = 133;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
Debug.ShouldStop(16);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Euro"))),(Object)(RemoteObject.createImmutable((0.94))));
 BA.debugLineNum = 135;BA.debugLine="mainConvert(dollarMoney.Get(from), dollarMoney.Ge";
Debug.ShouldStop(64);
_mainconvert(BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_into)))));
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _declarelist() throws Exception{
try {
		Debug.PushSubsStack("declareList (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,95);
if (RapidSub.canDelegate("declarelist")) { return b4a.example.main.remoteMe.runUserSub(false, "main","declarelist");}
RemoteObject _money = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 95;BA.debugLine="Sub declareList";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 97;BA.debugLine="Dim money As List";
Debug.ShouldStop(1);
_money = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("money", _money);
 BA.debugLineNum = 98;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
Debug.ShouldStop(2);
_money.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {RemoteObject.createImmutable(("PHP")),RemoteObject.createImmutable(("US Dollar")),RemoteObject.createImmutable(("Yuan")),RemoteObject.createImmutable(("Ruble")),(RemoteObject.createImmutable("Euro"))})))));
 BA.debugLineNum = 99;BA.debugLine="moneyBef.AddAll(money)";
Debug.ShouldStop(4);
main.mostCurrent._moneybef.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 100;BA.debugLine="moneyAf.AddAll(money)";
Debug.ShouldStop(8);
main.mostCurrent._moneyaf.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 103;BA.debugLine="Dim mass As List";
Debug.ShouldStop(64);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 104;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
Debug.ShouldStop(128);
_mass.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {RemoteObject.createImmutable(("kilogram")),RemoteObject.createImmutable(("gram")),(RemoteObject.createImmutable("pound"))})))));
 BA.debugLineNum = 105;BA.debugLine="massBef.AddAll(mass)";
Debug.ShouldStop(256);
main.mostCurrent._massbef.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 106;BA.debugLine="massAf.AddAll(mass)";
Debug.ShouldStop(512);
main.mostCurrent._massaf.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 109;BA.debugLine="Dim distance As List";
Debug.ShouldStop(4096);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 110;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
Debug.ShouldStop(8192);
_distance.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {RemoteObject.createImmutable(("kilometer")),RemoteObject.createImmutable(("centimeter")),RemoteObject.createImmutable(("meter")),(RemoteObject.createImmutable("foot"))})))));
 BA.debugLineNum = 111;BA.debugLine="distBef.AddAll(distance)";
Debug.ShouldStop(16384);
main.mostCurrent._distbef.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 112;BA.debugLine="distAf.AddAll(distance)";
Debug.ShouldStop(32768);
main.mostCurrent._distaf.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private background As Panel";
main.mostCurrent._background = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private userInp As Label";
main.mostCurrent._userinp = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private result As Label";
main.mostCurrent._result = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private moneyBef As Spinner";
main.mostCurrent._moneybef = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private moneyAf As Spinner";
main.mostCurrent._moneyaf = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private massBef As Spinner";
main.mostCurrent._massbef = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private massAf As Spinner";
main.mostCurrent._massaf = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private distBef As Spinner";
main.mostCurrent._distbef = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private distAf As Spinner";
main.mostCurrent._distaf = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private mainFrame, startFrame As Panel 'for layou";
main.mostCurrent._mainframe = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._startframe = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private coinClick As Boolean = False";
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 36;BA.debugLine="Private weightClick As Boolean = False";
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 37;BA.debugLine="Private lengthClick As Boolean = False";
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 41;BA.debugLine="Private first As Boolean = True";
main._first = main.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 42;BA.debugLine="Private second As Boolean = False";
main._second = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _init() throws Exception{
try {
		Debug.PushSubsStack("init (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
if (RapidSub.canDelegate("init")) { return b4a.example.main.remoteMe.runUserSub(false, "main","init");}
 BA.debugLineNum = 84;BA.debugLine="Sub init 'for loading the layout";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=Fals";
Debug.ShouldStop(1048576);
main.mostCurrent._mainframe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 85;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=Fals";
Debug.ShouldStop(1048576);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 86;BA.debugLine="Activity.AddView(mainFrame,0,0,100%x,100%y) 'addv";
Debug.ShouldStop(2097152);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._mainframe.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 87;BA.debugLine="mainFrame.LoadLayout(\"MainFrame\") ' load";
Debug.ShouldStop(4194304);
main.mostCurrent._mainframe.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainFrame")),main.mostCurrent.activityBA);
 BA.debugLineNum = 89;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Tr";
Debug.ShouldStop(16777216);
main.mostCurrent._startframe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 89;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Tr";
Debug.ShouldStop(16777216);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 90;BA.debugLine="Activity.AddView(startFrame,0,0,100%x,100%y)";
Debug.ShouldStop(33554432);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._startframe.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 91;BA.debugLine="startFrame.LoadLayout(\"StartingFrame\")";
Debug.ShouldStop(67108864);
main.mostCurrent._startframe.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("StartingFrame")),main.mostCurrent.activityBA);
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _input(RemoteObject _number) throws Exception{
try {
		Debug.PushSubsStack("input (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,297);
if (RapidSub.canDelegate("input")) { return b4a.example.main.remoteMe.runUserSub(false, "main","input", _number);}
RemoteObject _usr = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
Debug.locals.put("number", _number);
 BA.debugLineNum = 297;BA.debugLine="Sub input(number As String)";
Debug.ShouldStop(256);
 BA.debugLineNum = 299;BA.debugLine="If first = True Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main._first,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 300;BA.debugLine="If userInp.Text = 0 And number <> \".\" Then 'chec";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent._userinp.runMethod(true,"getText"),BA.NumberToString(0)) && RemoteObject.solveBoolean("!",_number,BA.ObjectToString("."))) { 
 BA.debugLineNum = 301;BA.debugLine="userInp.Text = number 'change the 0 to the inpu";
Debug.ShouldStop(4096);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(_number));
 BA.debugLineNum = 302;BA.debugLine="Return 'exit the process";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 306;BA.debugLine="If number = \".\" And userInp.Text.Contains(\".\") T";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_number,BA.ObjectToString(".")) && RemoteObject.solveBoolean(".",main.mostCurrent._userinp.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))))) { 
 BA.debugLineNum = 307;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 310;BA.debugLine="Dim usr As StringBuilder";
Debug.ShouldStop(2097152);
_usr = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("usr", _usr);
 BA.debugLineNum = 311;BA.debugLine="usr.Initialize";
Debug.ShouldStop(4194304);
_usr.runVoidMethod ("Initialize");
 BA.debugLineNum = 312;BA.debugLine="usr.Append(userInp.Text.Replace(\",\",\"\")) ' gets";
Debug.ShouldStop(8388608);
_usr.runVoidMethod ("Append",(Object)(main.mostCurrent._userinp.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 313;BA.debugLine="usr.Append(number) 'add the number that was clic";
Debug.ShouldStop(16777216);
_usr.runVoidMethod ("Append",(Object)(_number));
 BA.debugLineNum = 315;BA.debugLine="If checkhigh(usr) Then'checks where it is too hi";
Debug.ShouldStop(67108864);
if (_checkhigh(BA.ObjectToString(_usr)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 316;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 319;BA.debugLine="If number = \".\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_number,BA.ObjectToString("."))) { 
 BA.debugLineNum = 320;BA.debugLine="userInp.Text = usr";
Debug.ShouldStop(-2147483648);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(_usr.getObject()));
 BA.debugLineNum = 321;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 324;BA.debugLine="userInp.Text = NumberFormat(usr, 1, 10) 'update";
Debug.ShouldStop(8);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _usr)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)))));
 }else 
{ BA.debugLineNum = 325;BA.debugLine="Else if second = True Then 'same as the statment";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main._second,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 326;BA.debugLine="If result.Text = 0 And number <> \".\" Then 'check";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main.mostCurrent._result.runMethod(true,"getText"),BA.NumberToString(0)) && RemoteObject.solveBoolean("!",_number,BA.ObjectToString("."))) { 
 BA.debugLineNum = 327;BA.debugLine="result.Text = number 'change the 0 to the input";
Debug.ShouldStop(64);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(_number));
 BA.debugLineNum = 328;BA.debugLine="Return 'exit the process";
Debug.ShouldStop(128);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 333;BA.debugLine="If number = \".\" And result.Text.Contains(\".\") Th";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_number,BA.ObjectToString(".")) && RemoteObject.solveBoolean(".",main.mostCurrent._result.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))))) { 
 BA.debugLineNum = 334;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 338;BA.debugLine="Dim usr As StringBuilder";
Debug.ShouldStop(131072);
_usr = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("usr", _usr);
 BA.debugLineNum = 339;BA.debugLine="usr.Initialize";
Debug.ShouldStop(262144);
_usr.runVoidMethod ("Initialize");
 BA.debugLineNum = 340;BA.debugLine="usr.Append(result.Text.Replace(\",\",\"\")) ' gets t";
Debug.ShouldStop(524288);
_usr.runVoidMethod ("Append",(Object)(main.mostCurrent._result.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 341;BA.debugLine="usr.Append(number) 'add the number that was clic";
Debug.ShouldStop(1048576);
_usr.runVoidMethod ("Append",(Object)(_number));
 BA.debugLineNum = 342;BA.debugLine="If checkhigh(usr) Then'checks whether it is too";
Debug.ShouldStop(2097152);
if (_checkhigh(BA.ObjectToString(_usr)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 343;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 345;BA.debugLine="If number = \".\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_number,BA.ObjectToString("."))) { 
 BA.debugLineNum = 346;BA.debugLine="result.Text = usr";
Debug.ShouldStop(33554432);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(_usr.getObject()));
 BA.debugLineNum = 347;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 349;BA.debugLine="result.Text = NumberFormat(usr, 1, 10) 'update t";
Debug.ShouldStop(268435456);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(BA.numberCast(double.class, _usr)),(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 10)))));
 }}
;
 BA.debugLineNum = 352;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _length_click() throws Exception{
try {
		Debug.PushSubsStack("Length_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,221);
if (RapidSub.canDelegate("length_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","length_click");}
 BA.debugLineNum = 221;BA.debugLine="Private Sub Length_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 222;BA.debugLine="coinClick = False";
Debug.ShouldStop(536870912);
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 223;BA.debugLine="weightClick = False";
Debug.ShouldStop(1073741824);
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 224;BA.debugLine="lengthClick = True";
Debug.ShouldStop(-2147483648);
main._lengthclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 225;BA.debugLine="transferMain";
Debug.ShouldStop(1);
_transfermain();
 BA.debugLineNum = 226;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mainconvert(RemoteObject _from,RemoteObject _into) throws Exception{
try {
		Debug.PushSubsStack("mainConvert (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,179);
if (RapidSub.canDelegate("mainconvert")) { return b4a.example.main.remoteMe.runUserSub(false, "main","mainconvert", _from, _into);}
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _usr = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("from", _from);
Debug.locals.put("into", _into);
 BA.debugLineNum = 179;BA.debugLine="Sub mainConvert(from As Double, into As Double)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 181;BA.debugLine="Dim const place As Int = 15";
Debug.ShouldStop(1048576);
_place = BA.numberCast(int.class, 15);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 182;BA.debugLine="Dim const minInt As Int = 1";
Debug.ShouldStop(2097152);
_minint = BA.numberCast(int.class, 1);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 183;BA.debugLine="If first = True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main._first,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 185;BA.debugLine="Dim usr As Double = userInp.Text.Replace(\",\",\"\")";
Debug.ShouldStop(16777216);
_usr = BA.numberCast(double.class, main.mostCurrent._userinp.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable(""))));Debug.locals.put("usr", _usr);Debug.locals.put("usr", _usr);
 BA.debugLineNum = 189;BA.debugLine="Dim res As Double = usr/from * (into)";
Debug.ShouldStop(268435456);
_res = RemoteObject.solve(new RemoteObject[] {_usr,_from,(_into)}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 192;BA.debugLine="result.Text = NumberFormat(res,minInt, place)'di";
Debug.ShouldStop(-2147483648);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 }else 
{ BA.debugLineNum = 193;BA.debugLine="Else if second = True Then 'same as the statment";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",main._second,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 195;BA.debugLine="Dim usr As Double = result.Text.Replace(\",\",\"\")";
Debug.ShouldStop(4);
_usr = BA.numberCast(double.class, main.mostCurrent._result.runMethod(true,"getText").runMethod(true,"replace",(Object)(BA.ObjectToString(",")),(Object)(RemoteObject.createImmutable(""))));Debug.locals.put("usr", _usr);Debug.locals.put("usr", _usr);
 BA.debugLineNum = 199;BA.debugLine="Dim res As Double = usr/into * from";
Debug.ShouldStop(64);
_res = RemoteObject.solve(new RemoteObject[] {_usr,_into,_from}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 200;BA.debugLine="userInp.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(128);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 }}
;
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _result_click() throws Exception{
try {
		Debug.PushSubsStack("result_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,494);
if (RapidSub.canDelegate("result_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","result_click");}
 BA.debugLineNum = 494;BA.debugLine="Private Sub result_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 495;BA.debugLine="first = False";
Debug.ShouldStop(16384);
main._first = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 496;BA.debugLine="second = True";
Debug.ShouldStop(32768);
main._second = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 497;BA.debugLine="changeText";
Debug.ShouldStop(65536);
_changetext();
 BA.debugLineNum = 498;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _transfermain() throws Exception{
try {
		Debug.PushSubsStack("transferMain (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,230);
if (RapidSub.canDelegate("transfermain")) { return b4a.example.main.remoteMe.runUserSub(false, "main","transfermain");}
 BA.debugLineNum = 230;BA.debugLine="Sub transferMain";
Debug.ShouldStop(32);
 BA.debugLineNum = 232;BA.debugLine="startFrame.Visible = False";
Debug.ShouldStop(128);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 233;BA.debugLine="mainFrame.Visible = True";
Debug.ShouldStop(256);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 235;BA.debugLine="If coinClick = True Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",main._coinclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 236;BA.debugLine="moneyBef.Visible = True";
Debug.ShouldStop(2048);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 237;BA.debugLine="moneyAf.Visible = True";
Debug.ShouldStop(4096);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 239;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(16384);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 240;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(32768);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 242;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(131072);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 243;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 245;BA.debugLine="Else If weightClick = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main._weightclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 246;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(2097152);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 247;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(4194304);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 249;BA.debugLine="massBef.Visible = True";
Debug.ShouldStop(16777216);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 250;BA.debugLine="massAf.Visible = True";
Debug.ShouldStop(33554432);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 252;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(134217728);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 253;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(268435456);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 256;BA.debugLine="Else If lengthClick = True Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",main._lengthclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 257;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(1);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 258;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(2);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 260;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(8);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 261;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(16);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 263;BA.debugLine="distBef.Visible = True";
Debug.ShouldStop(64);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 264;BA.debugLine="distAf.Visible = True";
Debug.ShouldStop(128);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }}}
;
 BA.debugLineNum = 267;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _userinp_click() throws Exception{
try {
		Debug.PushSubsStack("userInp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,488);
if (RapidSub.canDelegate("userinp_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","userinp_click");}
 BA.debugLineNum = 488;BA.debugLine="Private Sub userInp_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 489;BA.debugLine="first = True";
Debug.ShouldStop(256);
main._first = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 490;BA.debugLine="second = False";
Debug.ShouldStop(512);
main._second = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 491;BA.debugLine="changeText";
Debug.ShouldStop(1024);
_changetext();
 BA.debugLineNum = 492;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _weight_click() throws Exception{
try {
		Debug.PushSubsStack("Weight_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,214);
if (RapidSub.canDelegate("weight_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","weight_click");}
 BA.debugLineNum = 214;BA.debugLine="Private Sub Weight_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 215;BA.debugLine="coinClick = False";
Debug.ShouldStop(4194304);
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 216;BA.debugLine="weightClick = True";
Debug.ShouldStop(8388608);
main._weightclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 217;BA.debugLine="lengthClick = False";
Debug.ShouldStop(16777216);
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 218;BA.debugLine="transferMain";
Debug.ShouldStop(33554432);
_transfermain();
 BA.debugLineNum = 219;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}