package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _inconvert = RemoteObject.createImmutable("");
RemoteObject _money = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=True";
Debug.ShouldStop(8192);
main.mostCurrent._mainframe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 46;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=True";
Debug.ShouldStop(8192);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 47;BA.debugLine="Activity.AddView(mainFrame,0,0,100%x,100%y)";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._mainframe.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 48;BA.debugLine="mainFrame.LoadLayout(\"MainFrame\")";
Debug.ShouldStop(32768);
main.mostCurrent._mainframe.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("MainFrame")),main.mostCurrent.activityBA);
 BA.debugLineNum = 50;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Fa";
Debug.ShouldStop(131072);
main.mostCurrent._startframe.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 50;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Fa";
Debug.ShouldStop(131072);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="Activity.AddView(startFrame,0,0,100%x,100%y)";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._startframe.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 52;BA.debugLine="startFrame.LoadLayout(\"StartingFrame\")";
Debug.ShouldStop(524288);
main.mostCurrent._startframe.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("StartingFrame")),main.mostCurrent.activityBA);
 BA.debugLineNum = 54;BA.debugLine="Dim inConvert As String = \"Convert\"";
Debug.ShouldStop(2097152);
_inconvert = BA.ObjectToString("Convert");Debug.locals.put("inConvert", _inconvert);Debug.locals.put("inConvert", _inconvert);
 BA.debugLineNum = 57;BA.debugLine="startFrame.Visible=True";
Debug.ShouldStop(16777216);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 60;BA.debugLine="userInp.InputType = userInp.INPUT_TYPE_DECIMAL_NU";
Debug.ShouldStop(134217728);
main.mostCurrent._userinp.runMethod(true,"setInputType",main.mostCurrent._userinp.getField(true,"INPUT_TYPE_DECIMAL_NUMBERS"));
 BA.debugLineNum = 62;BA.debugLine="moneyBef.Visible = True";
Debug.ShouldStop(536870912);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 63;BA.debugLine="moneyAf.Visible = True";
Debug.ShouldStop(1073741824);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 65;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(1);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 66;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(2);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(8);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 69;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(16);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 71;BA.debugLine="convertMoney.Visible = True";
Debug.ShouldStop(64);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 72;BA.debugLine="convertMass.Visible = False";
Debug.ShouldStop(128);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 73;BA.debugLine="convertDist.Visible = False";
Debug.ShouldStop(256);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 76;BA.debugLine="convertMoney.Text = inConvert";
Debug.ShouldStop(2048);
main.mostCurrent._convertmoney.runMethod(true,"setText",BA.ObjectToCharSequence(_inconvert));
 BA.debugLineNum = 77;BA.debugLine="convertDist.Text = inConvert";
Debug.ShouldStop(4096);
main.mostCurrent._convertdist.runMethod(true,"setText",BA.ObjectToCharSequence(_inconvert));
 BA.debugLineNum = 78;BA.debugLine="convertMass.Text = inConvert";
Debug.ShouldStop(8192);
main.mostCurrent._convertmass.runMethod(true,"setText",BA.ObjectToCharSequence(_inconvert));
 BA.debugLineNum = 80;BA.debugLine="userInp.Hint = \"Input\"";
Debug.ShouldStop(32768);
main.mostCurrent._userinp.runMethod(true,"setHint",BA.ObjectToString("Input"));
 BA.debugLineNum = 81;BA.debugLine="result.Text = \"Result\"";
Debug.ShouldStop(65536);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("Result"));
 BA.debugLineNum = 84;BA.debugLine="Dim money As List";
Debug.ShouldStop(524288);
_money = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("money", _money);
 BA.debugLineNum = 85;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
Debug.ShouldStop(1048576);
_money.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {RemoteObject.createImmutable(("PHP")),RemoteObject.createImmutable(("US Dollar")),RemoteObject.createImmutable(("Yuan")),RemoteObject.createImmutable(("Ruble")),(RemoteObject.createImmutable("Euro"))})))));
 BA.debugLineNum = 86;BA.debugLine="moneyBef.AddAll(money)";
Debug.ShouldStop(2097152);
main.mostCurrent._moneybef.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 87;BA.debugLine="moneyAf.AddAll(money)";
Debug.ShouldStop(4194304);
main.mostCurrent._moneyaf.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 90;BA.debugLine="Dim mass As List";
Debug.ShouldStop(33554432);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 91;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
Debug.ShouldStop(67108864);
_mass.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {RemoteObject.createImmutable(("kilogram")),RemoteObject.createImmutable(("gram")),(RemoteObject.createImmutable("pound"))})))));
 BA.debugLineNum = 92;BA.debugLine="massBef.AddAll(mass)";
Debug.ShouldStop(134217728);
main.mostCurrent._massbef.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 93;BA.debugLine="massAf.AddAll(mass)";
Debug.ShouldStop(268435456);
main.mostCurrent._massaf.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 96;BA.debugLine="Dim distance As List";
Debug.ShouldStop(-2147483648);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 97;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
Debug.ShouldStop(1);
_distance.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {RemoteObject.createImmutable(("kilometer")),RemoteObject.createImmutable(("centimeter")),RemoteObject.createImmutable(("meter")),(RemoteObject.createImmutable("foot"))})))));
 BA.debugLineNum = 98;BA.debugLine="distBef.AddAll(distance)";
Debug.ShouldStop(2);
main.mostCurrent._distbef.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 99;BA.debugLine="distAf.AddAll(distance)";
Debug.ShouldStop(4);
main.mostCurrent._distaf.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,106);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 106;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,102);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 102;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(32);
 BA.debugLineNum = 104;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("backImage_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,289);
if (RapidSub.canDelegate("backimage_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","backimage_click");}
 BA.debugLineNum = 289;BA.debugLine="Private Sub backImage_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 290;BA.debugLine="mainFrame.Visible = False";
Debug.ShouldStop(2);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 291;BA.debugLine="startFrame.Visible = True";
Debug.ShouldStop(4);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
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
public static RemoteObject  _checkvalue() throws Exception{
try {
		Debug.PushSubsStack("checkvalue (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,141);
if (RapidSub.canDelegate("checkvalue")) { return b4a.example.main.remoteMe.runUserSub(false, "main","checkvalue");}
RemoteObject _userinput = RemoteObject.createImmutable("");
RemoteObject _userinputdouble = RemoteObject.createImmutable(0);
 BA.debugLineNum = 141;BA.debugLine="Sub checkvalue() As Boolean";
Debug.ShouldStop(4096);
 BA.debugLineNum = 144;BA.debugLine="Dim userInput As String";
Debug.ShouldStop(32768);
_userinput = RemoteObject.createImmutable("");Debug.locals.put("userInput", _userinput);
 BA.debugLineNum = 145;BA.debugLine="userInput = userInp.Text";
Debug.ShouldStop(65536);
_userinput = main.mostCurrent._userinp.runMethod(true,"getText");Debug.locals.put("userInput", _userinput);
 BA.debugLineNum = 148;BA.debugLine="If userInput = \"\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_userinput,BA.ObjectToString(""))) { 
 BA.debugLineNum = 149;BA.debugLine="ToastMessageShow(\"Please enter a value\", True)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter a value")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 150;BA.debugLine="Return False";
Debug.ShouldStop(2097152);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 153;BA.debugLine="Dim userInputDouble As Double = userInp.Text";
Debug.ShouldStop(16777216);
_userinputdouble = BA.numberCast(double.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userInputDouble", _userinputdouble);Debug.locals.put("userInputDouble", _userinputdouble);
 BA.debugLineNum = 155;BA.debugLine="If userInputDouble < 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("<",_userinputdouble,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 156;BA.debugLine="ToastMessageShow(\"Please enter a positive number";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter a positive number")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 157;BA.debugLine="Return False";
Debug.ShouldStop(268435456);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 160;BA.debugLine="Return True";
Debug.ShouldStop(-2147483648);
if (true) return main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("coin_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,219);
if (RapidSub.canDelegate("coin_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","coin_click");}
 BA.debugLineNum = 219;BA.debugLine="Private Sub coin_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 220;BA.debugLine="coinClick = True";
Debug.ShouldStop(134217728);
main._coinclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 221;BA.debugLine="weightClick = False";
Debug.ShouldStop(268435456);
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 222;BA.debugLine="lengthClick = False";
Debug.ShouldStop(536870912);
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 223;BA.debugLine="transferMain";
Debug.ShouldStop(1073741824);
_transfermain();
 BA.debugLineNum = 224;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertdist_click() throws Exception{
try {
		Debug.PushSubsStack("convertDist_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,192);
if (RapidSub.canDelegate("convertdist_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertdist_click");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _userdistance = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 192;BA.debugLine="Private Sub convertDist_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="Dim from As String";
Debug.ShouldStop(1);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 194;BA.debugLine="from = distBef.SelectedItem";
Debug.ShouldStop(2);
_from = main.mostCurrent._distbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 196;BA.debugLine="Dim into As String";
Debug.ShouldStop(8);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 197;BA.debugLine="into = distAf.SelectedItem";
Debug.ShouldStop(16);
_into = main.mostCurrent._distaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 199;BA.debugLine="Dim distance As Map";
Debug.ShouldStop(64);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 200;BA.debugLine="distance.Initialize";
Debug.ShouldStop(128);
_distance.runVoidMethod ("Initialize");
 BA.debugLineNum = 202;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
Debug.ShouldStop(512);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilometer"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 203;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
Debug.ShouldStop(1024);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("centimeter"))),(Object)(RemoteObject.createImmutable((100.00))));
 BA.debugLineNum = 204;BA.debugLine="distance.Put(\"meter\", 1.00)";
Debug.ShouldStop(2048);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("meter"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 205;BA.debugLine="distance.Put(\"foot\", 3.28084)";
Debug.ShouldStop(4096);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("foot"))),(Object)(RemoteObject.createImmutable((3.28084))));
 BA.debugLineNum = 206;BA.debugLine="Dim userDistance As Float";
Debug.ShouldStop(8192);
_userdistance = RemoteObject.createImmutable(0f);Debug.locals.put("userDistance", _userdistance);
 BA.debugLineNum = 207;BA.debugLine="If(checkvalue) Then";
Debug.ShouldStop(16384);
if ((_checkvalue()).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 208;BA.debugLine="userDistance = userInp.Text";
Debug.ShouldStop(32768);
_userdistance = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userDistance", _userdistance);
 }else {
 BA.debugLineNum = 210;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 212;BA.debugLine="Dim const place As Int = 5";
Debug.ShouldStop(524288);
_place = BA.numberCast(int.class, 5);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 213;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(1048576);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 214;BA.debugLine="Dim res As Double = userDistance/distance.Get(fro";
Debug.ShouldStop(2097152);
_res = RemoteObject.solve(new RemoteObject[] {_userdistance,BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 215;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(4194304);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertmass_click() throws Exception{
try {
		Debug.PushSubsStack("convertMass_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,165);
if (RapidSub.canDelegate("convertmass_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmass_click");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _usermass = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 165;BA.debugLine="Private Sub convertMass_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="Dim from As String";
Debug.ShouldStop(32);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 167;BA.debugLine="from = massBef.SelectedItem";
Debug.ShouldStop(64);
_from = main.mostCurrent._massbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 169;BA.debugLine="Dim into As String";
Debug.ShouldStop(256);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 170;BA.debugLine="into = massAf.SelectedItem";
Debug.ShouldStop(512);
_into = main.mostCurrent._massaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 172;BA.debugLine="Dim mass As Map";
Debug.ShouldStop(2048);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 173;BA.debugLine="mass.Initialize";
Debug.ShouldStop(4096);
_mass.runVoidMethod ("Initialize");
 BA.debugLineNum = 177;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
Debug.ShouldStop(65536);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilogram"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 178;BA.debugLine="mass.Put(\"gram\", 1.00)";
Debug.ShouldStop(131072);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("gram"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 179;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
Debug.ShouldStop(262144);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("pound"))),(Object)(RemoteObject.createImmutable((0.00220462))));
 BA.debugLineNum = 180;BA.debugLine="Dim userMass As Float";
Debug.ShouldStop(524288);
_usermass = RemoteObject.createImmutable(0f);Debug.locals.put("userMass", _usermass);
 BA.debugLineNum = 181;BA.debugLine="If(checkvalue) Then";
Debug.ShouldStop(1048576);
if ((_checkvalue()).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 182;BA.debugLine="userMass = userInp.Text";
Debug.ShouldStop(2097152);
_usermass = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userMass", _usermass);
 }else {
 BA.debugLineNum = 184;BA.debugLine="Return";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 186;BA.debugLine="Dim const place As Int = 5";
Debug.ShouldStop(33554432);
_place = BA.numberCast(int.class, 5);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 187;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(67108864);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 188;BA.debugLine="Dim res As Double = userMass/mass.Get(from) * mas";
Debug.ShouldStop(134217728);
_res = RemoteObject.solve(new RemoteObject[] {_usermass,BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 189;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(268435456);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertmoney_click() throws Exception{
try {
		Debug.PushSubsStack("convertMoney_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("convertmoney_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmoney_click");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _dollarmoney = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _usermoney = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 111;BA.debugLine="Private Sub convertMoney_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Dim from As String";
Debug.ShouldStop(32768);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 113;BA.debugLine="from = moneyBef.SelectedItem";
Debug.ShouldStop(65536);
_from = main.mostCurrent._moneybef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 115;BA.debugLine="Dim into As String";
Debug.ShouldStop(262144);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 116;BA.debugLine="into = moneyAf.SelectedItem";
Debug.ShouldStop(524288);
_into = main.mostCurrent._moneyaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 118;BA.debugLine="Dim dollarMoney As Map";
Debug.ShouldStop(2097152);
_dollarmoney = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("dollarMoney", _dollarmoney);
 BA.debugLineNum = 119;BA.debugLine="dollarMoney.Initialize";
Debug.ShouldStop(4194304);
_dollarmoney.runVoidMethod ("Initialize");
 BA.debugLineNum = 123;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
Debug.ShouldStop(67108864);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("PHP"))),(Object)(RemoteObject.createImmutable((54.91))));
 BA.debugLineNum = 124;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
Debug.ShouldStop(134217728);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("US Dollar"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 125;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
Debug.ShouldStop(268435456);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Yuan"))),(Object)(RemoteObject.createImmutable((6.90))));
 BA.debugLineNum = 126;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
Debug.ShouldStop(536870912);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Ruble"))),(Object)(RemoteObject.createImmutable((76.26))));
 BA.debugLineNum = 127;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
Debug.ShouldStop(1073741824);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Euro"))),(Object)(RemoteObject.createImmutable((0.94))));
 BA.debugLineNum = 129;BA.debugLine="Dim userMoney As Float";
Debug.ShouldStop(1);
_usermoney = RemoteObject.createImmutable(0f);Debug.locals.put("userMoney", _usermoney);
 BA.debugLineNum = 130;BA.debugLine="If(checkvalue) Then";
Debug.ShouldStop(2);
if ((_checkvalue()).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 131;BA.debugLine="userMoney = userInp.Text";
Debug.ShouldStop(4);
_usermoney = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userMoney", _usermoney);
 }else {
 BA.debugLineNum = 133;BA.debugLine="Return";
Debug.ShouldStop(16);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 135;BA.debugLine="Dim const place As Int = 2";
Debug.ShouldStop(64);
_place = BA.numberCast(int.class, 2);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 136;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(128);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 137;BA.debugLine="Dim res As Double = userMoney/dollarMoney.Get(fro";
Debug.ShouldStop(256);
_res = RemoteObject.solve(new RemoteObject[] {_usermoney,BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 138;BA.debugLine="result.Text = NumberFormat(res, minInt, place)";
Debug.ShouldStop(512);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
 //BA.debugLineNum = 25;BA.debugLine="Private userInp As EditText";
main.mostCurrent._userinp = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
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
 //BA.debugLineNum = 33;BA.debugLine="Private convertMoney As Button";
main.mostCurrent._convertmoney = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private convertMass As Button";
main.mostCurrent._convertmass = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private convertDist As Button";
main.mostCurrent._convertdist = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private mainFrame, startFrame As Panel";
main.mostCurrent._mainframe = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._startframe = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private coinClick As Boolean = False";
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 39;BA.debugLine="Private weightClick As Boolean = False";
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 40;BA.debugLine="Private lengthClick As Boolean = False";
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _length_click() throws Exception{
try {
		Debug.PushSubsStack("Length_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,235);
if (RapidSub.canDelegate("length_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","length_click");}
 BA.debugLineNum = 235;BA.debugLine="Private Sub Length_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="coinClick = False";
Debug.ShouldStop(2048);
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 237;BA.debugLine="weightClick = False";
Debug.ShouldStop(4096);
main._weightclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 238;BA.debugLine="lengthClick = True";
Debug.ShouldStop(8192);
main._lengthclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 239;BA.debugLine="transferMain";
Debug.ShouldStop(16384);
_transfermain();
 BA.debugLineNum = 240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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
public static RemoteObject  _transfermain() throws Exception{
try {
		Debug.PushSubsStack("transferMain (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,242);
if (RapidSub.canDelegate("transfermain")) { return b4a.example.main.remoteMe.runUserSub(false, "main","transfermain");}
 BA.debugLineNum = 242;BA.debugLine="Sub transferMain";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="startFrame.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._startframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 244;BA.debugLine="mainFrame.Visible = True";
Debug.ShouldStop(524288);
main.mostCurrent._mainframe.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 245;BA.debugLine="If coinClick = True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main._coinclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 246;BA.debugLine="moneyBef.Visible = True";
Debug.ShouldStop(2097152);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 247;BA.debugLine="moneyAf.Visible = True";
Debug.ShouldStop(4194304);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 249;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(16777216);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 250;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(33554432);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 252;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(134217728);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 253;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(268435456);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 255;BA.debugLine="convertMoney.Visible = True";
Debug.ShouldStop(1073741824);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 256;BA.debugLine="convertMass.Visible = False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 257;BA.debugLine="convertDist.Visible = False";
Debug.ShouldStop(1);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 259;BA.debugLine="Else If weightClick = True Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main._weightclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 260;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(8);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 261;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(16);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 263;BA.debugLine="massBef.Visible = True";
Debug.ShouldStop(64);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 264;BA.debugLine="massAf.Visible = True";
Debug.ShouldStop(128);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 266;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(512);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 267;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(1024);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 269;BA.debugLine="convertMoney.Visible = False";
Debug.ShouldStop(4096);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 270;BA.debugLine="convertMass.Visible = True";
Debug.ShouldStop(8192);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 271;BA.debugLine="convertDist.Visible = False";
Debug.ShouldStop(16384);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 273;BA.debugLine="Else If lengthClick = True Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",main._lengthclick,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 274;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(131072);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 275;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 277;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(1048576);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 278;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(2097152);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 280;BA.debugLine="distBef.Visible = True";
Debug.ShouldStop(8388608);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 281;BA.debugLine="distAf.Visible = True";
Debug.ShouldStop(16777216);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 283;BA.debugLine="convertMoney.Visible = False";
Debug.ShouldStop(67108864);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 284;BA.debugLine="convertMass.Visible = False";
Debug.ShouldStop(134217728);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 285;BA.debugLine="convertDist.Visible = True";
Debug.ShouldStop(268435456);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }}}
;
 BA.debugLineNum = 287;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("Weight_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,228);
if (RapidSub.canDelegate("weight_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","weight_click");}
 BA.debugLineNum = 228;BA.debugLine="Private Sub Weight_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 229;BA.debugLine="coinClick = False";
Debug.ShouldStop(16);
main._coinclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 230;BA.debugLine="weightClick = True";
Debug.ShouldStop(32);
main._weightclick = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 231;BA.debugLine="lengthClick = False";
Debug.ShouldStop(64);
main._lengthclick = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 232;BA.debugLine="transferMain";
Debug.ShouldStop(128);
_transfermain();
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}