package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,45);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="init";
Debug.ShouldStop(16384);
_init();
 BA.debugLineNum = 51;BA.debugLine="userInp.Text = \"0\"";
Debug.ShouldStop(262144);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 52;BA.debugLine="result.Text = \"0\"";
Debug.ShouldStop(524288);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 55;BA.debugLine="declareList";
Debug.ShouldStop(4194304);
_declarelist();
 BA.debugLineNum = 58;BA.debugLine="changeText";
Debug.ShouldStop(33554432);
_changetext();
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,65);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 65;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,61);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 61;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("backImage_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,256);
if (RapidSub.canDelegate("backimage_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","backimage_click");}
 BA.debugLineNum = 256;BA.debugLine="Private Sub backImage_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 259;BA.debugLine="mainFrame.Visible = False";
Debug.ShouldStop(4);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 260;BA.debugLine="startFrame.Visible = True";
Debug.ShouldStop(8);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 262;BA.debugLine="userInp.Text = \"0\"";
Debug.ShouldStop(32);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 263;BA.debugLine="result.Text = \"0\"";
Debug.ShouldStop(64);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 264;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("backspace_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,295);
if (RapidSub.canDelegate("backspace_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","backspace_click");}
RemoteObject _usr = RemoteObject.createImmutable("");
 BA.debugLineNum = 295;BA.debugLine="Private Sub backspace_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 296;BA.debugLine="Dim usr As String = userInp.Text";
Debug.ShouldStop(128);
_usr = main.mostCurrent._userinp.runMethod(true,"getText");Debug.locals.put("usr", _usr);Debug.locals.put("usr", _usr);
 BA.debugLineNum = 297;BA.debugLine="If usr.Length > 1 Then 'checks if there is text";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",_usr.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 298;BA.debugLine="usr = usr.SubString2(0, usr.Length -1) 'removes";
Debug.ShouldStop(512);
_usr = _usr.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {_usr.runMethod(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1)));Debug.locals.put("usr", _usr);
 }else {
 BA.debugLineNum = 301;BA.debugLine="usr = \"0\" 'if deleted it will turn into 0";
Debug.ShouldStop(4096);
_usr = BA.ObjectToString("0");Debug.locals.put("usr", _usr);
 };
 BA.debugLineNum = 304;BA.debugLine="userInp.Text = usr";
Debug.ShouldStop(32768);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(_usr));
 BA.debugLineNum = 306;BA.debugLine="convert";
Debug.ShouldStop(131072);
_convert();
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Button0_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,324);
if (RapidSub.canDelegate("button0_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button0_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 324;BA.debugLine="Private Sub Button0_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 325;BA.debugLine="Dim const number As String = \"0\"";
Debug.ShouldStop(16);
_number = BA.ObjectToString("0");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 326;BA.debugLine="input(number)";
Debug.ShouldStop(32);
_input(_number);
 BA.debugLineNum = 327;BA.debugLine="convert";
Debug.ShouldStop(64);
_convert();
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Button1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,330);
if (RapidSub.canDelegate("button1_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button1_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 330;BA.debugLine="Private Sub Button1_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 331;BA.debugLine="Dim const number As String = \"1\"";
Debug.ShouldStop(1024);
_number = BA.ObjectToString("1");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 332;BA.debugLine="input(number)";
Debug.ShouldStop(2048);
_input(_number);
 BA.debugLineNum = 333;BA.debugLine="convert";
Debug.ShouldStop(4096);
_convert();
 BA.debugLineNum = 334;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Button2_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,336);
if (RapidSub.canDelegate("button2_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button2_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 336;BA.debugLine="Private Sub Button2_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 337;BA.debugLine="Dim const number As String = \"2\"";
Debug.ShouldStop(65536);
_number = BA.ObjectToString("2");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 338;BA.debugLine="input(number)";
Debug.ShouldStop(131072);
_input(_number);
 BA.debugLineNum = 339;BA.debugLine="convert";
Debug.ShouldStop(262144);
_convert();
 BA.debugLineNum = 340;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Button3_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,342);
if (RapidSub.canDelegate("button3_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button3_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 342;BA.debugLine="Private Sub Button3_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 343;BA.debugLine="Dim const number As String = \"3\"";
Debug.ShouldStop(4194304);
_number = BA.ObjectToString("3");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 344;BA.debugLine="input(number)";
Debug.ShouldStop(8388608);
_input(_number);
 BA.debugLineNum = 345;BA.debugLine="convert";
Debug.ShouldStop(16777216);
_convert();
 BA.debugLineNum = 346;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Button4_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,348);
if (RapidSub.canDelegate("button4_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button4_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 348;BA.debugLine="Private Sub Button4_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 349;BA.debugLine="Dim const number As String = \"4\"";
Debug.ShouldStop(268435456);
_number = BA.ObjectToString("4");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 350;BA.debugLine="input(number)";
Debug.ShouldStop(536870912);
_input(_number);
 BA.debugLineNum = 351;BA.debugLine="convert";
Debug.ShouldStop(1073741824);
_convert();
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
public static RemoteObject  _button5_click() throws Exception{
try {
		Debug.PushSubsStack("Button5_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,354);
if (RapidSub.canDelegate("button5_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button5_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 354;BA.debugLine="Private Sub Button5_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="Dim const number As String = \"5\"";
Debug.ShouldStop(4);
_number = BA.ObjectToString("5");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 356;BA.debugLine="input(number)";
Debug.ShouldStop(8);
_input(_number);
 BA.debugLineNum = 357;BA.debugLine="convert";
Debug.ShouldStop(16);
_convert();
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
public static RemoteObject  _button6_click() throws Exception{
try {
		Debug.PushSubsStack("Button6_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,360);
if (RapidSub.canDelegate("button6_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button6_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 360;BA.debugLine="Private Sub Button6_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 361;BA.debugLine="Dim const number As String = \"6\"";
Debug.ShouldStop(256);
_number = BA.ObjectToString("6");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 362;BA.debugLine="input(number)";
Debug.ShouldStop(512);
_input(_number);
 BA.debugLineNum = 363;BA.debugLine="convert";
Debug.ShouldStop(1024);
_convert();
 BA.debugLineNum = 364;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Button7_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,366);
if (RapidSub.canDelegate("button7_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button7_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 366;BA.debugLine="Private Sub Button7_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 367;BA.debugLine="Dim const number As String = \"7\"";
Debug.ShouldStop(16384);
_number = BA.ObjectToString("7");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 368;BA.debugLine="input(number)";
Debug.ShouldStop(32768);
_input(_number);
 BA.debugLineNum = 369;BA.debugLine="convert";
Debug.ShouldStop(65536);
_convert();
 BA.debugLineNum = 370;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Button8_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,372);
if (RapidSub.canDelegate("button8_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button8_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 372;BA.debugLine="Private Sub Button8_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 373;BA.debugLine="Dim const number As String = \"8\"";
Debug.ShouldStop(1048576);
_number = BA.ObjectToString("8");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 374;BA.debugLine="input(number)";
Debug.ShouldStop(2097152);
_input(_number);
 BA.debugLineNum = 375;BA.debugLine="convert";
Debug.ShouldStop(4194304);
_convert();
 BA.debugLineNum = 376;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Button9_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,378);
if (RapidSub.canDelegate("button9_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","button9_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 378;BA.debugLine="Private Sub Button9_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 379;BA.debugLine="Dim const number As String = \"9\"";
Debug.ShouldStop(67108864);
_number = BA.ObjectToString("9");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 380;BA.debugLine="input(number)";
Debug.ShouldStop(134217728);
_input(_number);
 BA.debugLineNum = 381;BA.debugLine="convert";
Debug.ShouldStop(268435456);
_convert();
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Buttonclear_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,287);
if (RapidSub.canDelegate("buttonclear_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttonclear_click");}
 BA.debugLineNum = 287;BA.debugLine="Private Sub Buttonclear_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 289;BA.debugLine="userInp.Text = \"0\"";
Debug.ShouldStop(1);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 290;BA.debugLine="result.Text = \"0\"";
Debug.ShouldStop(2);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("0"));
 BA.debugLineNum = 291;BA.debugLine="convert";
Debug.ShouldStop(4);
_convert();
 BA.debugLineNum = 292;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Buttondot_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,281);
if (RapidSub.canDelegate("buttondot_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","buttondot_click");}
RemoteObject _number = RemoteObject.createImmutable("");
 BA.debugLineNum = 281;BA.debugLine="Private Sub Buttondot_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 282;BA.debugLine="Dim number As String = \".\" 'adds a dot";
Debug.ShouldStop(33554432);
_number = BA.ObjectToString(".");Debug.locals.put("number", _number);Debug.locals.put("number", _number);
 BA.debugLineNum = 283;BA.debugLine="input(number)";
Debug.ShouldStop(67108864);
_input(_number);
 BA.debugLineNum = 284;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("changeText (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,69);
if (RapidSub.canDelegate("changetext")) { return b4a.example.main.remoteMe.runUserSub(false, "main","changetext");}
 BA.debugLineNum = 69;BA.debugLine="Sub changeText";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="If first Then";
Debug.ShouldStop(32);
if (main._first.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 71;BA.debugLine="userInp.TextColor = Colors.RGB(0,0,255)";
Debug.ShouldStop(64);
main.mostCurrent._userinp.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 72;BA.debugLine="userInp.TextSize = 30";
Debug.ShouldStop(128);
main.mostCurrent._userinp.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 BA.debugLineNum = 73;BA.debugLine="result.TextColor = Colors.RGB(0,0,0)";
Debug.ShouldStop(256);
main.mostCurrent._result.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 74;BA.debugLine="result.TextSize = 17";
Debug.ShouldStop(512);
main.mostCurrent._result.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 }else 
{ BA.debugLineNum = 75;BA.debugLine="Else If second Then";
Debug.ShouldStop(1024);
if (main._second.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 76;BA.debugLine="userInp.TextColor = Colors.RGB(0,0,0)";
Debug.ShouldStop(2048);
main.mostCurrent._userinp.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0))));
 BA.debugLineNum = 77;BA.debugLine="userInp.TextSize = 17";
Debug.ShouldStop(4096);
main.mostCurrent._userinp.runMethod(true,"setTextSize",BA.numberCast(float.class, 17));
 BA.debugLineNum = 78;BA.debugLine="result.TextColor = Colors.RGB(0,0,255)";
Debug.ShouldStop(8192);
main.mostCurrent._result.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 255))));
 BA.debugLineNum = 79;BA.debugLine="result.TextSize = 30";
Debug.ShouldStop(16384);
main.mostCurrent._result.runMethod(true,"setTextSize",BA.numberCast(float.class, 30));
 }}
;
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _coin_click() throws Exception{
try {
		Debug.PushSubsStack("coin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,193);
if (RapidSub.canDelegate("coin_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","coin_click");}
 BA.debugLineNum = 193;BA.debugLine="Private Sub coin_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="coinClick = True";
Debug.ShouldStop(2);
main._coinclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 195;BA.debugLine="weightClick = False";
Debug.ShouldStop(4);
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 196;BA.debugLine="lengthClick = False";
Debug.ShouldStop(8);
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 197;BA.debugLine="transferMain";
Debug.ShouldStop(16);
_transfermain();
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("convert (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,313);
if (RapidSub.canDelegate("convert")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convert");}
 BA.debugLineNum = 313;BA.debugLine="Sub convert";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 315;BA.debugLine="If coinClick = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",main._coinclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 316;BA.debugLine="convertMoney";
Debug.ShouldStop(134217728);
_convertmoney();
 }else 
{ BA.debugLineNum = 317;BA.debugLine="else if weightClick = True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main._weightclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 318;BA.debugLine="convertMass";
Debug.ShouldStop(536870912);
_convertmass();
 }else 
{ BA.debugLineNum = 319;BA.debugLine="else if lengthClick = True Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main._lengthclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 320;BA.debugLine="convertDist";
Debug.ShouldStop(-2147483648);
_convertdist();
 }}}
;
 BA.debugLineNum = 322;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("convertDist (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,168);
if (RapidSub.canDelegate("convertdist")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertdist");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _userdistance = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 168;BA.debugLine="Sub convertDist";
Debug.ShouldStop(128);
 BA.debugLineNum = 170;BA.debugLine="Dim from As String";
Debug.ShouldStop(512);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 171;BA.debugLine="from = distBef.SelectedItem";
Debug.ShouldStop(1024);
_from = main.mostCurrent._distbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 173;BA.debugLine="Dim into As String";
Debug.ShouldStop(4096);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 174;BA.debugLine="into = distAf.SelectedItem";
Debug.ShouldStop(8192);
_into = main.mostCurrent._distaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 176;BA.debugLine="Dim distance As Map";
Debug.ShouldStop(32768);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 177;BA.debugLine="distance.Initialize";
Debug.ShouldStop(65536);
_distance.runVoidMethod ("Initialize");
 BA.debugLineNum = 179;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
Debug.ShouldStop(262144);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilometer"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 180;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
Debug.ShouldStop(524288);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("centimeter"))),(Object)(RemoteObject.createImmutable((100.00))));
 BA.debugLineNum = 181;BA.debugLine="distance.Put(\"meter\", 1.00)";
Debug.ShouldStop(1048576);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("meter"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 182;BA.debugLine="distance.Put(\"foot\", 3.28084)";
Debug.ShouldStop(2097152);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("foot"))),(Object)(RemoteObject.createImmutable((3.28084))));
 BA.debugLineNum = 183;BA.debugLine="Dim userDistance As Float = userInp.Text";
Debug.ShouldStop(4194304);
_userdistance = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userDistance", _userdistance);Debug.locals.put("userDistance", _userdistance);
 BA.debugLineNum = 185;BA.debugLine="Dim const place As Int = 5";
Debug.ShouldStop(16777216);
_place = BA.numberCast(int.class, 5);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 186;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(33554432);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 187;BA.debugLine="Dim res As Double = userDistance/distance.Get(fro";
Debug.ShouldStop(67108864);
_res = RemoteObject.solve(new RemoteObject[] {_userdistance,BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 188;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(134217728);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 189;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("convertMass (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,143);
if (RapidSub.canDelegate("convertmass")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmass");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _usermass = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 143;BA.debugLine="Sub convertMass";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="Dim from As String";
Debug.ShouldStop(65536);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 146;BA.debugLine="from = massBef.SelectedItem";
Debug.ShouldStop(131072);
_from = main.mostCurrent._massbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 148;BA.debugLine="Dim into As String";
Debug.ShouldStop(524288);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 149;BA.debugLine="into = massAf.SelectedItem";
Debug.ShouldStop(1048576);
_into = main.mostCurrent._massaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 151;BA.debugLine="Dim mass As Map";
Debug.ShouldStop(4194304);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 152;BA.debugLine="mass.Initialize";
Debug.ShouldStop(8388608);
_mass.runVoidMethod ("Initialize");
 BA.debugLineNum = 156;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
Debug.ShouldStop(134217728);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilogram"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 157;BA.debugLine="mass.Put(\"gram\", 1.00)";
Debug.ShouldStop(268435456);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("gram"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 158;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
Debug.ShouldStop(536870912);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("pound"))),(Object)(RemoteObject.createImmutable((0.00220462))));
 BA.debugLineNum = 159;BA.debugLine="Dim userMass As Float = userInp.Text";
Debug.ShouldStop(1073741824);
_usermass = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userMass", _usermass);Debug.locals.put("userMass", _usermass);
 BA.debugLineNum = 161;BA.debugLine="Dim const place As Int = 5";
Debug.ShouldStop(1);
_place = BA.numberCast(int.class, 5);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 162;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(2);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 163;BA.debugLine="Dim res As Double = userMass/mass.Get(from) * mas";
Debug.ShouldStop(4);
_res = RemoteObject.solve(new RemoteObject[] {_usermass,BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 164;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(8);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 165;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("convertMoney (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("convertmoney")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmoney");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _dollarmoney = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _usermoney = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 115;BA.debugLine="Sub convertMoney";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="Dim from As String";
Debug.ShouldStop(1048576);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 118;BA.debugLine="from = moneyBef.SelectedItem 'get selected item";
Debug.ShouldStop(2097152);
_from = main.mostCurrent._moneybef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 120;BA.debugLine="Dim into As String";
Debug.ShouldStop(8388608);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 121;BA.debugLine="into = moneyAf.SelectedItem";
Debug.ShouldStop(16777216);
_into = main.mostCurrent._moneyaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 123;BA.debugLine="Dim dollarMoney As Map";
Debug.ShouldStop(67108864);
_dollarmoney = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("dollarMoney", _dollarmoney);
 BA.debugLineNum = 124;BA.debugLine="dollarMoney.Initialize";
Debug.ShouldStop(134217728);
_dollarmoney.runVoidMethod ("Initialize");
 BA.debugLineNum = 128;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
Debug.ShouldStop(-2147483648);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("PHP"))),(Object)(RemoteObject.createImmutable((54.91))));
 BA.debugLineNum = 129;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
Debug.ShouldStop(1);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("US Dollar"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 130;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
Debug.ShouldStop(2);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Yuan"))),(Object)(RemoteObject.createImmutable((6.90))));
 BA.debugLineNum = 131;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
Debug.ShouldStop(4);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Ruble"))),(Object)(RemoteObject.createImmutable((76.26))));
 BA.debugLineNum = 132;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
Debug.ShouldStop(8);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Euro"))),(Object)(RemoteObject.createImmutable((0.94))));
 BA.debugLineNum = 134;BA.debugLine="Dim userMoney As Float = userInp.Text";
Debug.ShouldStop(32);
_usermoney = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userMoney", _usermoney);Debug.locals.put("userMoney", _usermoney);
 BA.debugLineNum = 136;BA.debugLine="Dim const place As Int = 2";
Debug.ShouldStop(128);
_place = BA.numberCast(int.class, 2);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 137;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(256);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 138;BA.debugLine="Dim res As Double = userMoney/dollarMoney.Get(fro";
Debug.ShouldStop(512);
_res = RemoteObject.solve(new RemoteObject[] {_usermoney,BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 139;BA.debugLine="result.Text = NumberFormat(res, minInt, place)";
Debug.ShouldStop(1024);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("declareList (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,94);
if (RapidSub.canDelegate("declarelist")) { return b4a.example.main.remoteMe.runUserSub(false, "main","declarelist");}
RemoteObject _money = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 94;BA.debugLine="Sub declareList";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 96;BA.debugLine="Dim money As List";
Debug.ShouldStop(-2147483648);
_money = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("money", _money);
 BA.debugLineNum = 97;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
Debug.ShouldStop(1);
_money.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {RemoteObject.createImmutable(("PHP")),RemoteObject.createImmutable(("US Dollar")),RemoteObject.createImmutable(("Yuan")),RemoteObject.createImmutable(("Ruble")),(RemoteObject.createImmutable("Euro"))})))));
 BA.debugLineNum = 98;BA.debugLine="moneyBef.AddAll(money)";
Debug.ShouldStop(2);
main.mostCurrent._moneybef.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 99;BA.debugLine="moneyAf.AddAll(money)";
Debug.ShouldStop(4);
main.mostCurrent._moneyaf.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 102;BA.debugLine="Dim mass As List";
Debug.ShouldStop(32);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 103;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
Debug.ShouldStop(64);
_mass.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {RemoteObject.createImmutable(("kilogram")),RemoteObject.createImmutable(("gram")),(RemoteObject.createImmutable("pound"))})))));
 BA.debugLineNum = 104;BA.debugLine="massBef.AddAll(mass)";
Debug.ShouldStop(128);
main.mostCurrent._massbef.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 105;BA.debugLine="massAf.AddAll(mass)";
Debug.ShouldStop(256);
main.mostCurrent._massaf.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 108;BA.debugLine="Dim distance As List";
Debug.ShouldStop(2048);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 109;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
Debug.ShouldStop(4096);
_distance.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {RemoteObject.createImmutable(("kilometer")),RemoteObject.createImmutable(("centimeter")),RemoteObject.createImmutable(("meter")),(RemoteObject.createImmutable("foot"))})))));
 BA.debugLineNum = 110;BA.debugLine="distBef.AddAll(distance)";
Debug.ShouldStop(8192);
main.mostCurrent._distbef.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 111;BA.debugLine="distAf.AddAll(distance)";
Debug.ShouldStop(16384);
main.mostCurrent._distaf.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
 //BA.debugLineNum = 40;BA.debugLine="Private first As Boolean = True";
main._first = main.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 41;BA.debugLine="Private second As Boolean = False";
main._second = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _init() throws Exception{
try {
		Debug.PushSubsStack("init (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("init")) { return b4a.example.main.remoteMe.runUserSub(false, "main","init");}
 BA.debugLineNum = 83;BA.debugLine="Sub init 'for loading the layout";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=Fals";
Debug.ShouldStop(524288);
main.mostCurrent._mainframe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 84;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=Fals";
Debug.ShouldStop(524288);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 85;BA.debugLine="Activity.AddView(mainFrame,0,0,100%x,100%y) 'addv";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._mainframe.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 86;BA.debugLine="mainFrame.LoadLayout(\"MainFrame\") ' load";
Debug.ShouldStop(2097152);
main.mostCurrent._mainframe.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainFrame")),main.mostCurrent.activityBA);
 BA.debugLineNum = 88;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Tr";
Debug.ShouldStop(8388608);
main.mostCurrent._startframe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 88;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Tr";
Debug.ShouldStop(8388608);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 89;BA.debugLine="Activity.AddView(startFrame,0,0,100%x,100%y)";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._startframe.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 90;BA.debugLine="startFrame.LoadLayout(\"StartingFrame\")";
Debug.ShouldStop(33554432);
main.mostCurrent._startframe.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("StartingFrame")),main.mostCurrent.activityBA);
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("input (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,267);
if (RapidSub.canDelegate("input")) { return b4a.example.main.remoteMe.runUserSub(false, "main","input", _number);}
RemoteObject _usr = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
Debug.locals.put("number", _number);
 BA.debugLineNum = 267;BA.debugLine="Sub input(number As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 268;BA.debugLine="If userInp.Text = 0 Then 'checks if the value of";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent._userinp.runMethod(true,"getText"),BA.NumberToString(0))) { 
 BA.debugLineNum = 269;BA.debugLine="userInp.Text = number 'change the 0 to the input";
Debug.ShouldStop(4096);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(_number));
 BA.debugLineNum = 270;BA.debugLine="Return 'exit the process";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 273;BA.debugLine="Dim usr As StringBuilder";
Debug.ShouldStop(65536);
_usr = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("usr", _usr);
 BA.debugLineNum = 274;BA.debugLine="usr.Initialize";
Debug.ShouldStop(131072);
_usr.runVoidMethod ("Initialize");
 BA.debugLineNum = 275;BA.debugLine="usr.Append(userInp.Text) ' gets the user inp text";
Debug.ShouldStop(262144);
_usr.runVoidMethod ("Append",(Object)(main.mostCurrent._userinp.runMethod(true,"getText")));
 BA.debugLineNum = 276;BA.debugLine="usr.Append(number) 'add the number that was click";
Debug.ShouldStop(524288);
_usr.runVoidMethod ("Append",(Object)(_number));
 BA.debugLineNum = 277;BA.debugLine="userInp.Text = usr 'update the userinp";
Debug.ShouldStop(1048576);
main.mostCurrent._userinp.runMethod(true,"setText",BA.ObjectToCharSequence(_usr.getObject()));
 BA.debugLineNum = 278;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Length_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,208);
if (RapidSub.canDelegate("length_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","length_click");}
 BA.debugLineNum = 208;BA.debugLine="Private Sub Length_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 209;BA.debugLine="coinClick = False";
Debug.ShouldStop(65536);
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 210;BA.debugLine="weightClick = False";
Debug.ShouldStop(131072);
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 211;BA.debugLine="lengthClick = True";
Debug.ShouldStop(262144);
main._lengthclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 212;BA.debugLine="transferMain";
Debug.ShouldStop(524288);
_transfermain();
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("result_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,392);
if (RapidSub.canDelegate("result_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","result_click");}
 BA.debugLineNum = 392;BA.debugLine="Private Sub result_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 393;BA.debugLine="first = False";
Debug.ShouldStop(256);
main._first = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 394;BA.debugLine="second = True";
Debug.ShouldStop(512);
main._second = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 395;BA.debugLine="changeText";
Debug.ShouldStop(1024);
_changetext();
 BA.debugLineNum = 396;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("transferMain (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,217);
if (RapidSub.canDelegate("transfermain")) { return b4a.example.main.remoteMe.runUserSub(false, "main","transfermain");}
 BA.debugLineNum = 217;BA.debugLine="Sub transferMain";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 219;BA.debugLine="startFrame.Visible = False";
Debug.ShouldStop(67108864);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 220;BA.debugLine="mainFrame.Visible = True";
Debug.ShouldStop(134217728);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 222;BA.debugLine="If coinClick = True Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main._coinclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 223;BA.debugLine="moneyBef.Visible = True";
Debug.ShouldStop(1073741824);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 224;BA.debugLine="moneyAf.Visible = True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 226;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(2);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 227;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(4);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 229;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(16);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 230;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(32);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 232;BA.debugLine="Else If weightClick = True Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",main._weightclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 233;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(256);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 234;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(512);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 236;BA.debugLine="massBef.Visible = True";
Debug.ShouldStop(2048);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 237;BA.debugLine="massAf.Visible = True";
Debug.ShouldStop(4096);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 239;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(16384);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 240;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(32768);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 243;BA.debugLine="Else If lengthClick = True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main._lengthclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 244;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(524288);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 245;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(1048576);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 247;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(4194304);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 248;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(8388608);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 250;BA.debugLine="distBef.Visible = True";
Debug.ShouldStop(33554432);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 251;BA.debugLine="distAf.Visible = True";
Debug.ShouldStop(67108864);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }}}
;
 BA.debugLineNum = 254;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("userInp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,386);
if (RapidSub.canDelegate("userinp_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","userinp_click");}
 BA.debugLineNum = 386;BA.debugLine="Private Sub userInp_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 387;BA.debugLine="first = True";
Debug.ShouldStop(4);
main._first = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 388;BA.debugLine="second = False";
Debug.ShouldStop(8);
main._second = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 389;BA.debugLine="changeText";
Debug.ShouldStop(16);
_changetext();
 BA.debugLineNum = 390;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("Weight_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,201);
if (RapidSub.canDelegate("weight_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","weight_click");}
 BA.debugLineNum = 201;BA.debugLine="Private Sub Weight_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 202;BA.debugLine="coinClick = False";
Debug.ShouldStop(512);
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 203;BA.debugLine="weightClick = True";
Debug.ShouldStop(1024);
main._weightclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 204;BA.debugLine="lengthClick = False";
Debug.ShouldStop(2048);
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 205;BA.debugLine="transferMain";
Debug.ShouldStop(4096);
_transfermain();
 BA.debugLineNum = 206;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}