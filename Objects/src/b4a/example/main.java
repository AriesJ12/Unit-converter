package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create " + (isFirst ? "(first time)" : "") + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _converterspn = null;
public anywheresoftware.b4a.objects.EditTextWrapper _userinp = null;
public anywheresoftware.b4a.objects.LabelWrapper _result = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _moneybef = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _moneyaf = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _massbef = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _massaf = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _distbef = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _distaf = null;
public anywheresoftware.b4a.objects.ButtonWrapper _convertmoney = null;
public anywheresoftware.b4a.objects.ButtonWrapper _convertmass = null;
public anywheresoftware.b4a.objects.ButtonWrapper _convertdist = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
String _inconvert = "";
anywheresoftware.b4a.objects.collections.List _money = null;
anywheresoftware.b4a.objects.collections.List _mass = null;
anywheresoftware.b4a.objects.collections.List _distance = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"Layout\")";
mostCurrent._activity.LoadLayout("Layout",mostCurrent.activityBA);
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Dim inConvert As String = \"Convert\"";
_inconvert = "Convert";
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="userInp.InputType = userInp.INPUT_TYPE_DECIMAL_NU";
mostCurrent._userinp.setInputType(mostCurrent._userinp.INPUT_TYPE_DECIMAL_NUMBERS);
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="moneyBef.Visible = True";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="moneyAf.Visible = True";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="convertMoney.Visible = True";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="convertMass.Visible = False";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="convertDist.Visible = False";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="convertMoney.Text = inConvert";
mostCurrent._convertmoney.setText(BA.ObjectToCharSequence(_inconvert));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="convertDist.Text = inConvert";
mostCurrent._convertdist.setText(BA.ObjectToCharSequence(_inconvert));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="convertMass.Text = inConvert";
mostCurrent._convertmass.setText(BA.ObjectToCharSequence(_inconvert));
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="userInp.Hint = \"Input\"";
mostCurrent._userinp.setHint("Input");
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="result.Text = \"Result\"";
mostCurrent._result.setText(BA.ObjectToCharSequence("Result"));
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="converterSpn.Add(\"Currency\")";
mostCurrent._converterspn.Add("Currency");
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="converterSpn.Add(\"Mass\")";
mostCurrent._converterspn.Add("Mass");
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="converterSpn.Add(\"Distance/length\")";
mostCurrent._converterspn.Add("Distance/length");
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="Dim money As List";
_money = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
_money.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("PHP"),(Object)("US Dollar"),(Object)("Yuan"),(Object)("Ruble"),(Object)("Euro")}));
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="moneyBef.AddAll(money)";
mostCurrent._moneybef.AddAll(_money);
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="moneyAf.AddAll(money)";
mostCurrent._moneyaf.AddAll(_money);
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="Dim mass As List";
_mass = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
_mass.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("kilogram"),(Object)("gram"),(Object)("pound")}));
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="massBef.AddAll(mass)";
mostCurrent._massbef.AddAll(_mass);
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="massAf.AddAll(mass)";
mostCurrent._massaf.AddAll(_mass);
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="Dim distance As List";
_distance = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131121;
 //BA.debugLineNum = 131121;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
_distance.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("kilometer"),(Object)("centimeter"),(Object)("meter"),(Object)("foot")}));
RDebugUtils.currentLine=131122;
 //BA.debugLineNum = 131122;BA.debugLine="distBef.AddAll(distance)";
mostCurrent._distbef.AddAll(_distance);
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="distAf.AddAll(distance)";
mostCurrent._distaf.AddAll(_distance);
RDebugUtils.currentLine=131124;
 //BA.debugLineNum = 131124;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkvalue() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checkvalue", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "checkvalue", null));}
String _userinput = "";
double _userinputdouble = 0;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub checkvalue() As Boolean";
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim userInput As String";
_userinput = "";
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="userInput = userInp.Text";
_userinput = mostCurrent._userinp.getText();
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="If userInput = \"\" Then";
if ((_userinput).equals("")) { 
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="ToastMessageShow(\"Please enter a value\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter a value"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="Dim userInputDouble As Double = userInp.Text";
_userinputdouble = (double)(Double.parseDouble(mostCurrent._userinp.getText()));
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="If userInputDouble < 0 Then";
if (_userinputdouble<0) { 
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="ToastMessageShow(\"Please enter a positive number";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter a positive number"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572880;
 //BA.debugLineNum = 1572880;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1572885;
 //BA.debugLineNum = 1572885;BA.debugLine="End Sub";
return false;
}
public static String  _convertdist_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convertdist_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convertdist_click", null));}
String _from = "";
String _into = "";
anywheresoftware.b4a.objects.collections.Map _distance = null;
float _userdistance = 0f;
int _place = 0;
int _minint = 0;
double _res = 0;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Private Sub convertDist_Click";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="from = distBef.SelectedItem";
_from = mostCurrent._distbef.getSelectedItem();
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="into = distAf.SelectedItem";
_into = mostCurrent._distaf.getSelectedItem();
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="Dim distance As Map";
_distance = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="distance.Initialize";
_distance.Initialize();
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
_distance.Put((Object)("kilometer"),(Object)(0.001));
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
_distance.Put((Object)("centimeter"),(Object)(100.00));
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="distance.Put(\"meter\", 1.00)";
_distance.Put((Object)("meter"),(Object)(1.00));
RDebugUtils.currentLine=2162701;
 //BA.debugLineNum = 2162701;BA.debugLine="distance.Put(\"foot\", 3.28084)";
_distance.Put((Object)("foot"),(Object)(3.28084));
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="Dim userDistance As Float";
_userdistance = 0f;
RDebugUtils.currentLine=2162703;
 //BA.debugLineNum = 2162703;BA.debugLine="If(checkvalue) Then";
if ((_checkvalue())) { 
RDebugUtils.currentLine=2162704;
 //BA.debugLineNum = 2162704;BA.debugLine="userDistance = userInp.Text";
_userdistance = (float)(Double.parseDouble(mostCurrent._userinp.getText()));
 }else {
RDebugUtils.currentLine=2162706;
 //BA.debugLineNum = 2162706;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="Dim const place As Int = 5";
_place = (int) (5);
RDebugUtils.currentLine=2162709;
 //BA.debugLineNum = 2162709;BA.debugLine="Dim const minInt As Int = 0";
_minint = (int) (0);
RDebugUtils.currentLine=2162710;
 //BA.debugLineNum = 2162710;BA.debugLine="Dim res As Double = userDistance/distance.Get(fro";
_res = _userdistance/(double)(double)(BA.ObjectToNumber(_distance.Get((Object)(_from))))*(double)(BA.ObjectToNumber(_distance.Get((Object)(_into))));
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
RDebugUtils.currentLine=2162712;
 //BA.debugLineNum = 2162712;BA.debugLine="End Sub";
return "";
}
public static String  _converterspn_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "converterspn_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "converterspn_itemclick", new Object[] {_position,_value}));}
int _convert = 0;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub converterSpn_ItemClick (Position As In";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim convert As Int = converterSpn.SelectedIndex";
_convert = mostCurrent._converterspn.getSelectedIndex();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="If convert = 0 Then";
if (_convert==0) { 
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="moneyBef.Visible = True";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="moneyAf.Visible = True";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="convertMoney.Visible = True";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031630;
 //BA.debugLineNum = 2031630;BA.debugLine="convertMass.Visible = False";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="convertDist.Visible = False";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=2031633;
 //BA.debugLineNum = 2031633;BA.debugLine="Else If convert = 1 Then";
if (_convert==1) { 
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="moneyBef.Visible = False";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="moneyAf.Visible = False";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031637;
 //BA.debugLineNum = 2031637;BA.debugLine="massBef.Visible = True";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031638;
 //BA.debugLineNum = 2031638;BA.debugLine="massAf.Visible = True";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031640;
 //BA.debugLineNum = 2031640;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031641;
 //BA.debugLineNum = 2031641;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031643;
 //BA.debugLineNum = 2031643;BA.debugLine="convertMoney.Visible = False";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031644;
 //BA.debugLineNum = 2031644;BA.debugLine="convertMass.Visible = True";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031645;
 //BA.debugLineNum = 2031645;BA.debugLine="convertDist.Visible = False";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=2031646;
 //BA.debugLineNum = 2031646;BA.debugLine="Else If convert = 2 Then";
if (_convert==2) { 
RDebugUtils.currentLine=2031647;
 //BA.debugLineNum = 2031647;BA.debugLine="moneyBef.Visible = False";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031648;
 //BA.debugLineNum = 2031648;BA.debugLine="moneyAf.Visible = False";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031650;
 //BA.debugLineNum = 2031650;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031651;
 //BA.debugLineNum = 2031651;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031653;
 //BA.debugLineNum = 2031653;BA.debugLine="distBef.Visible = True";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031654;
 //BA.debugLineNum = 2031654;BA.debugLine="distAf.Visible = True";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031656;
 //BA.debugLineNum = 2031656;BA.debugLine="convertMoney.Visible = False";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031657;
 //BA.debugLineNum = 2031657;BA.debugLine="convertMass.Visible = False";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031658;
 //BA.debugLineNum = 2031658;BA.debugLine="convertDist.Visible = True";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }}}
;
RDebugUtils.currentLine=2031660;
 //BA.debugLineNum = 2031660;BA.debugLine="End Sub";
return "";
}
public static String  _convertmass_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convertmass_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convertmass_click", null));}
String _from = "";
String _into = "";
anywheresoftware.b4a.objects.collections.Map _mass = null;
float _usermass = 0f;
int _place = 0;
int _minint = 0;
double _res = 0;
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Private Sub convertMass_Click";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="from = massBef.SelectedItem";
_from = mostCurrent._massbef.getSelectedItem();
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="into = massAf.SelectedItem";
_into = mostCurrent._massaf.getSelectedItem();
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="Dim mass As Map";
_mass = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="mass.Initialize";
_mass.Initialize();
RDebugUtils.currentLine=2228236;
 //BA.debugLineNum = 2228236;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
_mass.Put((Object)("kilogram"),(Object)(0.001));
RDebugUtils.currentLine=2228237;
 //BA.debugLineNum = 2228237;BA.debugLine="mass.Put(\"gram\", 1.00)";
_mass.Put((Object)("gram"),(Object)(1.00));
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
_mass.Put((Object)("pound"),(Object)(0.00220462));
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="Dim userMass As Float";
_usermass = 0f;
RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="If(checkvalue) Then";
if ((_checkvalue())) { 
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="userMass = userInp.Text";
_usermass = (float)(Double.parseDouble(mostCurrent._userinp.getText()));
 }else {
RDebugUtils.currentLine=2228243;
 //BA.debugLineNum = 2228243;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2228245;
 //BA.debugLineNum = 2228245;BA.debugLine="Dim const place As Int = 5";
_place = (int) (5);
RDebugUtils.currentLine=2228246;
 //BA.debugLineNum = 2228246;BA.debugLine="Dim const minInt As Int = 0";
_minint = (int) (0);
RDebugUtils.currentLine=2228247;
 //BA.debugLineNum = 2228247;BA.debugLine="Dim res As Double = userMass/mass.Get(from) * mas";
_res = _usermass/(double)(double)(BA.ObjectToNumber(_mass.Get((Object)(_from))))*(double)(BA.ObjectToNumber(_mass.Get((Object)(_into))));
RDebugUtils.currentLine=2228248;
 //BA.debugLineNum = 2228248;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
RDebugUtils.currentLine=2228249;
 //BA.debugLineNum = 2228249;BA.debugLine="End Sub";
return "";
}
public static String  _convertmoney_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convertmoney_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convertmoney_click", null));}
String _from = "";
String _into = "";
anywheresoftware.b4a.objects.collections.Map _dollarmoney = null;
float _usermoney = 0f;
int _place = 0;
int _minint = 0;
double _res = 0;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub convertMoney_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="from = moneyBef.SelectedItem";
_from = mostCurrent._moneybef.getSelectedItem();
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="into = moneyAf.SelectedItem";
_into = mostCurrent._moneyaf.getSelectedItem();
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="Dim dollarMoney As Map";
_dollarmoney = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="dollarMoney.Initialize";
_dollarmoney.Initialize();
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
_dollarmoney.Put((Object)("PHP"),(Object)(54.91));
RDebugUtils.currentLine=1966093;
 //BA.debugLineNum = 1966093;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
_dollarmoney.Put((Object)("US Dollar"),(Object)(1.00));
RDebugUtils.currentLine=1966094;
 //BA.debugLineNum = 1966094;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
_dollarmoney.Put((Object)("Yuan"),(Object)(6.90));
RDebugUtils.currentLine=1966095;
 //BA.debugLineNum = 1966095;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
_dollarmoney.Put((Object)("Ruble"),(Object)(76.26));
RDebugUtils.currentLine=1966096;
 //BA.debugLineNum = 1966096;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
_dollarmoney.Put((Object)("Euro"),(Object)(0.94));
RDebugUtils.currentLine=1966098;
 //BA.debugLineNum = 1966098;BA.debugLine="Dim userMoney As Float";
_usermoney = 0f;
RDebugUtils.currentLine=1966099;
 //BA.debugLineNum = 1966099;BA.debugLine="If(checkvalue) Then";
if ((_checkvalue())) { 
RDebugUtils.currentLine=1966100;
 //BA.debugLineNum = 1966100;BA.debugLine="userMoney = userInp.Text";
_usermoney = (float)(Double.parseDouble(mostCurrent._userinp.getText()));
 }else {
RDebugUtils.currentLine=1966102;
 //BA.debugLineNum = 1966102;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1966104;
 //BA.debugLineNum = 1966104;BA.debugLine="Dim const place As Int = 2";
_place = (int) (2);
RDebugUtils.currentLine=1966105;
 //BA.debugLineNum = 1966105;BA.debugLine="Dim const minInt As Int = 0";
_minint = (int) (0);
RDebugUtils.currentLine=1966106;
 //BA.debugLineNum = 1966106;BA.debugLine="Dim res As Double = userMoney/dollarMoney.Get(fro";
_res = _usermoney/(double)(double)(BA.ObjectToNumber(_dollarmoney.Get((Object)(_from))))*(double)(BA.ObjectToNumber(_dollarmoney.Get((Object)(_into))));
RDebugUtils.currentLine=1966107;
 //BA.debugLineNum = 1966107;BA.debugLine="result.Text = NumberFormat(res, minInt, place)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
RDebugUtils.currentLine=1966108;
 //BA.debugLineNum = 1966108;BA.debugLine="End Sub";
return "";
}
}