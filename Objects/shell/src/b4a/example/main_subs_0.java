package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
RemoteObject _inconvert = RemoteObject.createImmutable("");
RemoteObject _money = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"Layout\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Layout")),main.mostCurrent.activityBA);
 BA.debugLineNum = 40;BA.debugLine="Dim inConvert As String = \"Convert\"";
Debug.ShouldStop(128);
_inconvert = BA.ObjectToString("Convert");Debug.locals.put("inConvert", _inconvert);Debug.locals.put("inConvert", _inconvert);
 BA.debugLineNum = 44;BA.debugLine="userInp.InputType = userInp.INPUT_TYPE_DECIMAL_NU";
Debug.ShouldStop(2048);
main.mostCurrent._userinp.runMethod(true,"setInputType",main.mostCurrent._userinp.getField(true,"INPUT_TYPE_DECIMAL_NUMBERS"));
 BA.debugLineNum = 47;BA.debugLine="moneyBef.Visible = True";
Debug.ShouldStop(16384);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 48;BA.debugLine="moneyAf.Visible = True";
Debug.ShouldStop(32768);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 50;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(131072);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 51;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 53;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(1048576);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 54;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(2097152);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 56;BA.debugLine="convertMoney.Visible = True";
Debug.ShouldStop(8388608);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 57;BA.debugLine="convertMass.Visible = False";
Debug.ShouldStop(16777216);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 58;BA.debugLine="convertDist.Visible = False";
Debug.ShouldStop(33554432);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 61;BA.debugLine="convertMoney.Text = inConvert";
Debug.ShouldStop(268435456);
main.mostCurrent._convertmoney.runMethod(true,"setText",BA.ObjectToCharSequence(_inconvert));
 BA.debugLineNum = 62;BA.debugLine="convertDist.Text = inConvert";
Debug.ShouldStop(536870912);
main.mostCurrent._convertdist.runMethod(true,"setText",BA.ObjectToCharSequence(_inconvert));
 BA.debugLineNum = 63;BA.debugLine="convertMass.Text = inConvert";
Debug.ShouldStop(1073741824);
main.mostCurrent._convertmass.runMethod(true,"setText",BA.ObjectToCharSequence(_inconvert));
 BA.debugLineNum = 65;BA.debugLine="userInp.Hint = \"Input\"";
Debug.ShouldStop(1);
main.mostCurrent._userinp.runMethod(true,"setHint",BA.ObjectToString("Input"));
 BA.debugLineNum = 66;BA.debugLine="result.Text = \"Result\"";
Debug.ShouldStop(2);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence("Result"));
 BA.debugLineNum = 69;BA.debugLine="converterSpn.Add(\"Currency\")";
Debug.ShouldStop(16);
main.mostCurrent._converterspn.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Currency")));
 BA.debugLineNum = 70;BA.debugLine="converterSpn.Add(\"Mass\")";
Debug.ShouldStop(32);
main.mostCurrent._converterspn.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Mass")));
 BA.debugLineNum = 71;BA.debugLine="converterSpn.Add(\"Distance/length\")";
Debug.ShouldStop(64);
main.mostCurrent._converterspn.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Distance/length")));
 BA.debugLineNum = 74;BA.debugLine="Dim money As List";
Debug.ShouldStop(512);
_money = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("money", _money);
 BA.debugLineNum = 75;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
Debug.ShouldStop(1024);
_money.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {5},new Object[] {RemoteObject.createImmutable(("PHP")),RemoteObject.createImmutable(("US Dollar")),RemoteObject.createImmutable(("Yuan")),RemoteObject.createImmutable(("Ruble")),(RemoteObject.createImmutable("Euro"))})))));
 BA.debugLineNum = 76;BA.debugLine="moneyBef.AddAll(money)";
Debug.ShouldStop(2048);
main.mostCurrent._moneybef.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 77;BA.debugLine="moneyAf.AddAll(money)";
Debug.ShouldStop(4096);
main.mostCurrent._moneyaf.runVoidMethod ("AddAll",(Object)(_money));
 BA.debugLineNum = 80;BA.debugLine="Dim mass As List";
Debug.ShouldStop(32768);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 81;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
Debug.ShouldStop(65536);
_mass.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {RemoteObject.createImmutable(("kilogram")),RemoteObject.createImmutable(("gram")),(RemoteObject.createImmutable("pound"))})))));
 BA.debugLineNum = 82;BA.debugLine="massBef.AddAll(mass)";
Debug.ShouldStop(131072);
main.mostCurrent._massbef.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 83;BA.debugLine="massAf.AddAll(mass)";
Debug.ShouldStop(262144);
main.mostCurrent._massaf.runVoidMethod ("AddAll",(Object)(_mass));
 BA.debugLineNum = 86;BA.debugLine="Dim distance As List";
Debug.ShouldStop(2097152);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 87;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
Debug.ShouldStop(4194304);
_distance.runVoidMethod ("Initialize2",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {4},new Object[] {RemoteObject.createImmutable(("kilometer")),RemoteObject.createImmutable(("centimeter")),RemoteObject.createImmutable(("meter")),(RemoteObject.createImmutable("foot"))})))));
 BA.debugLineNum = 88;BA.debugLine="distBef.AddAll(distance)";
Debug.ShouldStop(8388608);
main.mostCurrent._distbef.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 89;BA.debugLine="distAf.AddAll(distance)";
Debug.ShouldStop(16777216);
main.mostCurrent._distaf.runVoidMethod ("AddAll",(Object)(_distance));
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,96);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 96;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 92;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("checkvalue (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,131);
if (RapidSub.canDelegate("checkvalue")) { return b4a.example.main.remoteMe.runUserSub(false, "main","checkvalue");}
RemoteObject _userinput = RemoteObject.createImmutable("");
RemoteObject _userinputdouble = RemoteObject.createImmutable(0);
 BA.debugLineNum = 131;BA.debugLine="Sub checkvalue() As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 134;BA.debugLine="Dim userInput As String";
Debug.ShouldStop(32);
_userinput = RemoteObject.createImmutable("");Debug.locals.put("userInput", _userinput);
 BA.debugLineNum = 135;BA.debugLine="userInput = userInp.Text";
Debug.ShouldStop(64);
_userinput = main.mostCurrent._userinp.runMethod(true,"getText");Debug.locals.put("userInput", _userinput);
 BA.debugLineNum = 138;BA.debugLine="If userInput = \"\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_userinput,BA.ObjectToString(""))) { 
 BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"Please enter a value\", True)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter a value")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 140;BA.debugLine="Return False";
Debug.ShouldStop(2048);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 143;BA.debugLine="Dim userInputDouble As Double = userInp.Text";
Debug.ShouldStop(16384);
_userinputdouble = BA.numberCast(double.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userInputDouble", _userinputdouble);Debug.locals.put("userInputDouble", _userinputdouble);
 BA.debugLineNum = 145;BA.debugLine="If userInputDouble < 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("<",_userinputdouble,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 146;BA.debugLine="ToastMessageShow(\"Please enter a positive number";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Please enter a positive number")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 147;BA.debugLine="Return False";
Debug.ShouldStop(262144);
if (true) return main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 150;BA.debugLine="Return True";
Debug.ShouldStop(2097152);
if (true) return main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 152;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _convertdist_click() throws Exception{
try {
		Debug.PushSubsStack("convertDist_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,228);
if (RapidSub.canDelegate("convertdist_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertdist_click");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _distance = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _userdistance = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 228;BA.debugLine="Private Sub convertDist_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 229;BA.debugLine="Dim from As String";
Debug.ShouldStop(16);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 230;BA.debugLine="from = distBef.SelectedItem";
Debug.ShouldStop(32);
_from = main.mostCurrent._distbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 232;BA.debugLine="Dim into As String";
Debug.ShouldStop(128);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 233;BA.debugLine="into = distAf.SelectedItem";
Debug.ShouldStop(256);
_into = main.mostCurrent._distaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 235;BA.debugLine="Dim distance As Map";
Debug.ShouldStop(1024);
_distance = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("distance", _distance);
 BA.debugLineNum = 236;BA.debugLine="distance.Initialize";
Debug.ShouldStop(2048);
_distance.runVoidMethod ("Initialize");
 BA.debugLineNum = 238;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
Debug.ShouldStop(8192);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilometer"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 239;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
Debug.ShouldStop(16384);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("centimeter"))),(Object)(RemoteObject.createImmutable((100.00))));
 BA.debugLineNum = 240;BA.debugLine="distance.Put(\"meter\", 1.00)";
Debug.ShouldStop(32768);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("meter"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 241;BA.debugLine="distance.Put(\"foot\", 3.28084)";
Debug.ShouldStop(65536);
_distance.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("foot"))),(Object)(RemoteObject.createImmutable((3.28084))));
 BA.debugLineNum = 242;BA.debugLine="Dim userDistance As Float";
Debug.ShouldStop(131072);
_userdistance = RemoteObject.createImmutable(0f);Debug.locals.put("userDistance", _userdistance);
 BA.debugLineNum = 243;BA.debugLine="If(checkvalue) Then";
Debug.ShouldStop(262144);
if ((_checkvalue()).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 244;BA.debugLine="userDistance = userInp.Text";
Debug.ShouldStop(524288);
_userdistance = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userDistance", _userdistance);
 }else {
 BA.debugLineNum = 246;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 248;BA.debugLine="Dim const place As Int = 5";
Debug.ShouldStop(8388608);
_place = BA.numberCast(int.class, 5);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 249;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(16777216);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 250;BA.debugLine="Dim res As Double = userDistance/distance.Get(fro";
Debug.ShouldStop(33554432);
_res = RemoteObject.solve(new RemoteObject[] {_userdistance,BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _distance.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 251;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(67108864);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _converterspn_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("converterSpn_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,155);
if (RapidSub.canDelegate("converterspn_itemclick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","converterspn_itemclick", _position, _value);}
RemoteObject _convert = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 155;BA.debugLine="Private Sub converterSpn_ItemClick (Position As In";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 156;BA.debugLine="Dim convert As Int = converterSpn.SelectedIndex";
Debug.ShouldStop(134217728);
_convert = main.mostCurrent._converterspn.runMethod(true,"getSelectedIndex");Debug.locals.put("convert", _convert);Debug.locals.put("convert", _convert);
 BA.debugLineNum = 158;BA.debugLine="If convert = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_convert,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 159;BA.debugLine="moneyBef.Visible = True";
Debug.ShouldStop(1073741824);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 160;BA.debugLine="moneyAf.Visible = True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 162;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(2);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 163;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(4);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 165;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(16);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 166;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(32);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 168;BA.debugLine="convertMoney.Visible = True";
Debug.ShouldStop(128);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 169;BA.debugLine="convertMass.Visible = False";
Debug.ShouldStop(256);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="convertDist.Visible = False";
Debug.ShouldStop(512);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 172;BA.debugLine="Else If convert = 1 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_convert,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 173;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(4096);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 174;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(8192);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 176;BA.debugLine="massBef.Visible = True";
Debug.ShouldStop(32768);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 177;BA.debugLine="massAf.Visible = True";
Debug.ShouldStop(65536);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 179;BA.debugLine="distBef.Visible = False";
Debug.ShouldStop(262144);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 180;BA.debugLine="distAf.Visible = False";
Debug.ShouldStop(524288);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 182;BA.debugLine="convertMoney.Visible = False";
Debug.ShouldStop(2097152);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 183;BA.debugLine="convertMass.Visible = True";
Debug.ShouldStop(4194304);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 184;BA.debugLine="convertDist.Visible = False";
Debug.ShouldStop(8388608);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 185;BA.debugLine="Else If convert = 2 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_convert,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 186;BA.debugLine="moneyBef.Visible = False";
Debug.ShouldStop(33554432);
main.mostCurrent._moneybef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 187;BA.debugLine="moneyAf.Visible = False";
Debug.ShouldStop(67108864);
main.mostCurrent._moneyaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 189;BA.debugLine="massBef.Visible = False";
Debug.ShouldStop(268435456);
main.mostCurrent._massbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 190;BA.debugLine="massAf.Visible = False";
Debug.ShouldStop(536870912);
main.mostCurrent._massaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 192;BA.debugLine="distBef.Visible = True";
Debug.ShouldStop(-2147483648);
main.mostCurrent._distbef.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="distAf.Visible = True";
Debug.ShouldStop(1);
main.mostCurrent._distaf.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 195;BA.debugLine="convertMoney.Visible = False";
Debug.ShouldStop(4);
main.mostCurrent._convertmoney.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 196;BA.debugLine="convertMass.Visible = False";
Debug.ShouldStop(8);
main.mostCurrent._convertmass.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 197;BA.debugLine="convertDist.Visible = True";
Debug.ShouldStop(16);
main.mostCurrent._convertdist.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 }}}
;
 BA.debugLineNum = 199;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("convertMass_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,201);
if (RapidSub.canDelegate("convertmass_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmass_click");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _mass = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _usermass = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 201;BA.debugLine="Private Sub convertMass_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 202;BA.debugLine="Dim from As String";
Debug.ShouldStop(512);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 203;BA.debugLine="from = massBef.SelectedItem";
Debug.ShouldStop(1024);
_from = main.mostCurrent._massbef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 205;BA.debugLine="Dim into As String";
Debug.ShouldStop(4096);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 206;BA.debugLine="into = massAf.SelectedItem";
Debug.ShouldStop(8192);
_into = main.mostCurrent._massaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 208;BA.debugLine="Dim mass As Map";
Debug.ShouldStop(32768);
_mass = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mass", _mass);
 BA.debugLineNum = 209;BA.debugLine="mass.Initialize";
Debug.ShouldStop(65536);
_mass.runVoidMethod ("Initialize");
 BA.debugLineNum = 213;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
Debug.ShouldStop(1048576);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("kilogram"))),(Object)(RemoteObject.createImmutable((0.001))));
 BA.debugLineNum = 214;BA.debugLine="mass.Put(\"gram\", 1.00)";
Debug.ShouldStop(2097152);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("gram"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 215;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
Debug.ShouldStop(4194304);
_mass.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("pound"))),(Object)(RemoteObject.createImmutable((0.00220462))));
 BA.debugLineNum = 216;BA.debugLine="Dim userMass As Float";
Debug.ShouldStop(8388608);
_usermass = RemoteObject.createImmutable(0f);Debug.locals.put("userMass", _usermass);
 BA.debugLineNum = 217;BA.debugLine="If(checkvalue) Then";
Debug.ShouldStop(16777216);
if ((_checkvalue()).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 218;BA.debugLine="userMass = userInp.Text";
Debug.ShouldStop(33554432);
_usermass = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userMass", _usermass);
 }else {
 BA.debugLineNum = 220;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 222;BA.debugLine="Dim const place As Int = 5";
Debug.ShouldStop(536870912);
_place = BA.numberCast(int.class, 5);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 223;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(1073741824);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 224;BA.debugLine="Dim res As Double = userMass/mass.Get(from) * mas";
Debug.ShouldStop(-2147483648);
_res = RemoteObject.solve(new RemoteObject[] {_usermass,BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _mass.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 225;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
Debug.ShouldStop(1);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
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
public static RemoteObject  _convertmoney_click() throws Exception{
try {
		Debug.PushSubsStack("convertMoney_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,101);
if (RapidSub.canDelegate("convertmoney_click")) { return b4a.example.main.remoteMe.runUserSub(false, "main","convertmoney_click");}
RemoteObject _from = RemoteObject.createImmutable("");
RemoteObject _into = RemoteObject.createImmutable("");
RemoteObject _dollarmoney = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _usermoney = RemoteObject.createImmutable(0f);
RemoteObject _place = RemoteObject.createImmutable(0);
RemoteObject _minint = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
 BA.debugLineNum = 101;BA.debugLine="Private Sub convertMoney_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="Dim from As String";
Debug.ShouldStop(32);
_from = RemoteObject.createImmutable("");Debug.locals.put("from", _from);
 BA.debugLineNum = 103;BA.debugLine="from = moneyBef.SelectedItem";
Debug.ShouldStop(64);
_from = main.mostCurrent._moneybef.runMethod(true,"getSelectedItem");Debug.locals.put("from", _from);
 BA.debugLineNum = 105;BA.debugLine="Dim into As String";
Debug.ShouldStop(256);
_into = RemoteObject.createImmutable("");Debug.locals.put("into", _into);
 BA.debugLineNum = 106;BA.debugLine="into = moneyAf.SelectedItem";
Debug.ShouldStop(512);
_into = main.mostCurrent._moneyaf.runMethod(true,"getSelectedItem");Debug.locals.put("into", _into);
 BA.debugLineNum = 108;BA.debugLine="Dim dollarMoney As Map";
Debug.ShouldStop(2048);
_dollarmoney = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("dollarMoney", _dollarmoney);
 BA.debugLineNum = 109;BA.debugLine="dollarMoney.Initialize";
Debug.ShouldStop(4096);
_dollarmoney.runVoidMethod ("Initialize");
 BA.debugLineNum = 113;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
Debug.ShouldStop(65536);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("PHP"))),(Object)(RemoteObject.createImmutable((54.91))));
 BA.debugLineNum = 114;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
Debug.ShouldStop(131072);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("US Dollar"))),(Object)(RemoteObject.createImmutable((1.00))));
 BA.debugLineNum = 115;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
Debug.ShouldStop(262144);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Yuan"))),(Object)(RemoteObject.createImmutable((6.90))));
 BA.debugLineNum = 116;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
Debug.ShouldStop(524288);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Ruble"))),(Object)(RemoteObject.createImmutable((76.26))));
 BA.debugLineNum = 117;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
Debug.ShouldStop(1048576);
_dollarmoney.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("Euro"))),(Object)(RemoteObject.createImmutable((0.94))));
 BA.debugLineNum = 119;BA.debugLine="Dim userMoney As Float";
Debug.ShouldStop(4194304);
_usermoney = RemoteObject.createImmutable(0f);Debug.locals.put("userMoney", _usermoney);
 BA.debugLineNum = 120;BA.debugLine="If(checkvalue) Then";
Debug.ShouldStop(8388608);
if ((_checkvalue()).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 121;BA.debugLine="userMoney = userInp.Text";
Debug.ShouldStop(16777216);
_usermoney = BA.numberCast(float.class, main.mostCurrent._userinp.runMethod(true,"getText"));Debug.locals.put("userMoney", _usermoney);
 }else {
 BA.debugLineNum = 123;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 125;BA.debugLine="Dim const place As Int = 2";
Debug.ShouldStop(268435456);
_place = BA.numberCast(int.class, 2);Debug.locals.put("place", _place);Debug.locals.put("place", _place);
 BA.debugLineNum = 126;BA.debugLine="Dim const minInt As Int = 0";
Debug.ShouldStop(536870912);
_minint = BA.numberCast(int.class, 0);Debug.locals.put("minInt", _minint);Debug.locals.put("minInt", _minint);
 BA.debugLineNum = 127;BA.debugLine="Dim res As Double = userMoney/dollarMoney.Get(fro";
Debug.ShouldStop(1073741824);
_res = RemoteObject.solve(new RemoteObject[] {_usermoney,BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_from)))),BA.numberCast(double.class, _dollarmoney.runMethod(false,"Get",(Object)((_into))))}, "/*",0, 0);Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 128;BA.debugLine="result.Text = NumberFormat(res, minInt, place)";
Debug.ShouldStop(-2147483648);
main.mostCurrent._result.runMethod(true,"setText",BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(true,"NumberFormat",(Object)(_res),(Object)(_minint),(Object)(_place))));
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
 //BA.debugLineNum = 24;BA.debugLine="Private converterSpn As Spinner";
main.mostCurrent._converterspn = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
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
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

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
}