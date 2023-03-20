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
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
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
public anywheresoftware.b4a.objects.PanelWrapper _background = null;
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
public anywheresoftware.b4a.objects.PanelWrapper _mainframe = null;
public anywheresoftware.b4a.objects.PanelWrapper _startframe = null;
public static boolean _coinclick = false;
public static boolean _weightclick = false;
public static boolean _lengthclick = false;
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
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=True";
mostCurrent._mainframe.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=True";
mostCurrent._mainframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.AddView(mainFrame,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._mainframe.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="mainFrame.LoadLayout(\"MainFrame\")";
mostCurrent._mainframe.LoadLayout("MainFrame",mostCurrent.activityBA);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Fa";
mostCurrent._startframe.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Fa";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.AddView(startFrame,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._startframe.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="startFrame.LoadLayout(\"StartingFrame\")";
mostCurrent._startframe.LoadLayout("StartingFrame",mostCurrent.activityBA);
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Dim inConvert As String = \"Convert\"";
_inconvert = "Convert";
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="startFrame.Visible=True";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="userInp.InputType = userInp.INPUT_TYPE_DECIMAL_NU";
mostCurrent._userinp.setInputType(mostCurrent._userinp.INPUT_TYPE_DECIMAL_NUMBERS);
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="moneyBef.Visible = True";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="moneyAf.Visible = True";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="convertMoney.Visible = True";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="convertMass.Visible = False";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="convertDist.Visible = False";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="convertMoney.Text = inConvert";
mostCurrent._convertmoney.setText(BA.ObjectToCharSequence(_inconvert));
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="convertDist.Text = inConvert";
mostCurrent._convertdist.setText(BA.ObjectToCharSequence(_inconvert));
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="convertMass.Text = inConvert";
mostCurrent._convertmass.setText(BA.ObjectToCharSequence(_inconvert));
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="userInp.Hint = \"Input\"";
mostCurrent._userinp.setHint("Input");
RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="result.Text = \"Result\"";
mostCurrent._result.setText(BA.ObjectToCharSequence("Result"));
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="Dim money As List";
_money = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
_money.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("PHP"),(Object)("US Dollar"),(Object)("Yuan"),(Object)("Ruble"),(Object)("Euro")}));
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="moneyBef.AddAll(money)";
mostCurrent._moneybef.AddAll(_money);
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="moneyAf.AddAll(money)";
mostCurrent._moneyaf.AddAll(_money);
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="Dim mass As List";
_mass = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131119;
 //BA.debugLineNum = 131119;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
_mass.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("kilogram"),(Object)("gram"),(Object)("pound")}));
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="massBef.AddAll(mass)";
mostCurrent._massbef.AddAll(_mass);
RDebugUtils.currentLine=131121;
 //BA.debugLineNum = 131121;BA.debugLine="massAf.AddAll(mass)";
mostCurrent._massaf.AddAll(_mass);
RDebugUtils.currentLine=131124;
 //BA.debugLineNum = 131124;BA.debugLine="Dim distance As List";
_distance = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131125;
 //BA.debugLineNum = 131125;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
_distance.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("kilometer"),(Object)("centimeter"),(Object)("meter"),(Object)("foot")}));
RDebugUtils.currentLine=131126;
 //BA.debugLineNum = 131126;BA.debugLine="distBef.AddAll(distance)";
mostCurrent._distbef.AddAll(_distance);
RDebugUtils.currentLine=131127;
 //BA.debugLineNum = 131127;BA.debugLine="distAf.AddAll(distance)";
mostCurrent._distaf.AddAll(_distance);
RDebugUtils.currentLine=131128;
 //BA.debugLineNum = 131128;BA.debugLine="End Sub";
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
public static String  _backimage_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backimage_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backimage_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub backImage_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="mainFrame.Visible = False";
mostCurrent._mainframe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="startFrame.Visible = True";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkvalue() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checkvalue", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "checkvalue", null));}
String _userinput = "";
double _userinputdouble = 0;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub checkvalue() As Boolean";
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="Dim userInput As String";
_userinput = "";
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="userInput = userInp.Text";
_userinput = mostCurrent._userinp.getText();
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="If userInput = \"\" Then";
if ((_userinput).equals("")) { 
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="ToastMessageShow(\"Please enter a value\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter a value"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=393228;
 //BA.debugLineNum = 393228;BA.debugLine="Dim userInputDouble As Double = userInp.Text";
_userinputdouble = (double)(Double.parseDouble(mostCurrent._userinp.getText()));
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="If userInputDouble < 0 Then";
if (_userinputdouble<0) { 
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="ToastMessageShow(\"Please enter a positive number";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Please enter a positive number"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393232;
 //BA.debugLineNum = 393232;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="End Sub";
return false;
}
public static String  _coin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "coin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "coin_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub coin_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="coinClick = True";
_coinclick = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="weightClick = False";
_weightclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="lengthClick = False";
_lengthclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="transferMain";
_transfermain();
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="End Sub";
return "";
}
public static String  _transfermain() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "transfermain", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "transfermain", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub transferMain";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="startFrame.Visible = False";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="mainFrame.Visible = True";
mostCurrent._mainframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="If coinClick = True Then";
if (_coinclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="moneyBef.Visible = True";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="moneyAf.Visible = True";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="convertMoney.Visible = True";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="convertMass.Visible = False";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="convertDist.Visible = False";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="Else If weightClick = True Then";
if (_weightclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="moneyBef.Visible = False";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786451;
 //BA.debugLineNum = 786451;BA.debugLine="moneyAf.Visible = False";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786453;
 //BA.debugLineNum = 786453;BA.debugLine="massBef.Visible = True";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786454;
 //BA.debugLineNum = 786454;BA.debugLine="massAf.Visible = True";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786457;
 //BA.debugLineNum = 786457;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786459;
 //BA.debugLineNum = 786459;BA.debugLine="convertMoney.Visible = False";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786460;
 //BA.debugLineNum = 786460;BA.debugLine="convertMass.Visible = True";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786461;
 //BA.debugLineNum = 786461;BA.debugLine="convertDist.Visible = False";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=786463;
 //BA.debugLineNum = 786463;BA.debugLine="Else If lengthClick = True Then";
if (_lengthclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=786464;
 //BA.debugLineNum = 786464;BA.debugLine="moneyBef.Visible = False";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786465;
 //BA.debugLineNum = 786465;BA.debugLine="moneyAf.Visible = False";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786467;
 //BA.debugLineNum = 786467;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786468;
 //BA.debugLineNum = 786468;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786470;
 //BA.debugLineNum = 786470;BA.debugLine="distBef.Visible = True";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786471;
 //BA.debugLineNum = 786471;BA.debugLine="distAf.Visible = True";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786473;
 //BA.debugLineNum = 786473;BA.debugLine="convertMoney.Visible = False";
mostCurrent._convertmoney.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786474;
 //BA.debugLineNum = 786474;BA.debugLine="convertMass.Visible = False";
mostCurrent._convertmass.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786475;
 //BA.debugLineNum = 786475;BA.debugLine="convertDist.Visible = True";
mostCurrent._convertdist.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }}}
;
RDebugUtils.currentLine=786477;
 //BA.debugLineNum = 786477;BA.debugLine="End Sub";
return "";
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
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub convertDist_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="from = distBef.SelectedItem";
_from = mostCurrent._distbef.getSelectedItem();
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="into = distAf.SelectedItem";
_into = mostCurrent._distaf.getSelectedItem();
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="Dim distance As Map";
_distance = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="distance.Initialize";
_distance.Initialize();
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
_distance.Put((Object)("kilometer"),(Object)(0.001));
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
_distance.Put((Object)("centimeter"),(Object)(100.00));
RDebugUtils.currentLine=524300;
 //BA.debugLineNum = 524300;BA.debugLine="distance.Put(\"meter\", 1.00)";
_distance.Put((Object)("meter"),(Object)(1.00));
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="distance.Put(\"foot\", 3.28084)";
_distance.Put((Object)("foot"),(Object)(3.28084));
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="Dim userDistance As Float";
_userdistance = 0f;
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="If(checkvalue) Then";
if ((_checkvalue())) { 
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="userDistance = userInp.Text";
_userdistance = (float)(Double.parseDouble(mostCurrent._userinp.getText()));
 }else {
RDebugUtils.currentLine=524306;
 //BA.debugLineNum = 524306;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="Dim const place As Int = 5";
_place = (int) (5);
RDebugUtils.currentLine=524309;
 //BA.debugLineNum = 524309;BA.debugLine="Dim const minInt As Int = 0";
_minint = (int) (0);
RDebugUtils.currentLine=524310;
 //BA.debugLineNum = 524310;BA.debugLine="Dim res As Double = userDistance/distance.Get(fro";
_res = _userdistance/(double)(double)(BA.ObjectToNumber(_distance.Get((Object)(_from))))*(double)(BA.ObjectToNumber(_distance.Get((Object)(_into))));
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
RDebugUtils.currentLine=524312;
 //BA.debugLineNum = 524312;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Private Sub convertMass_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="from = massBef.SelectedItem";
_from = mostCurrent._massbef.getSelectedItem();
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="into = massAf.SelectedItem";
_into = mostCurrent._massaf.getSelectedItem();
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Dim mass As Map";
_mass = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="mass.Initialize";
_mass.Initialize();
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
_mass.Put((Object)("kilogram"),(Object)(0.001));
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="mass.Put(\"gram\", 1.00)";
_mass.Put((Object)("gram"),(Object)(1.00));
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
_mass.Put((Object)("pound"),(Object)(0.00220462));
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="Dim userMass As Float";
_usermass = 0f;
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="If(checkvalue) Then";
if ((_checkvalue())) { 
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="userMass = userInp.Text";
_usermass = (float)(Double.parseDouble(mostCurrent._userinp.getText()));
 }else {
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="Dim const place As Int = 5";
_place = (int) (5);
RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="Dim const minInt As Int = 0";
_minint = (int) (0);
RDebugUtils.currentLine=458775;
 //BA.debugLineNum = 458775;BA.debugLine="Dim res As Double = userMass/mass.Get(from) * mas";
_res = _usermass/(double)(double)(BA.ObjectToNumber(_mass.Get((Object)(_from))))*(double)(BA.ObjectToNumber(_mass.Get((Object)(_into))));
RDebugUtils.currentLine=458776;
 //BA.debugLineNum = 458776;BA.debugLine="result.Text = NumberFormat(res,minInt, place)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub convertMoney_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="from = moneyBef.SelectedItem";
_from = mostCurrent._moneybef.getSelectedItem();
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="into = moneyAf.SelectedItem";
_into = mostCurrent._moneyaf.getSelectedItem();
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="Dim dollarMoney As Map";
_dollarmoney = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="dollarMoney.Initialize";
_dollarmoney.Initialize();
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
_dollarmoney.Put((Object)("PHP"),(Object)(54.91));
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
_dollarmoney.Put((Object)("US Dollar"),(Object)(1.00));
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
_dollarmoney.Put((Object)("Yuan"),(Object)(6.90));
RDebugUtils.currentLine=327695;
 //BA.debugLineNum = 327695;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
_dollarmoney.Put((Object)("Ruble"),(Object)(76.26));
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
_dollarmoney.Put((Object)("Euro"),(Object)(0.94));
RDebugUtils.currentLine=327698;
 //BA.debugLineNum = 327698;BA.debugLine="Dim userMoney As Float";
_usermoney = 0f;
RDebugUtils.currentLine=327699;
 //BA.debugLineNum = 327699;BA.debugLine="If(checkvalue) Then";
if ((_checkvalue())) { 
RDebugUtils.currentLine=327700;
 //BA.debugLineNum = 327700;BA.debugLine="userMoney = userInp.Text";
_usermoney = (float)(Double.parseDouble(mostCurrent._userinp.getText()));
 }else {
RDebugUtils.currentLine=327702;
 //BA.debugLineNum = 327702;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=327704;
 //BA.debugLineNum = 327704;BA.debugLine="Dim const place As Int = 2";
_place = (int) (2);
RDebugUtils.currentLine=327705;
 //BA.debugLineNum = 327705;BA.debugLine="Dim const minInt As Int = 0";
_minint = (int) (0);
RDebugUtils.currentLine=327706;
 //BA.debugLineNum = 327706;BA.debugLine="Dim res As Double = userMoney/dollarMoney.Get(fro";
_res = _usermoney/(double)(double)(BA.ObjectToNumber(_dollarmoney.Get((Object)(_from))))*(double)(BA.ObjectToNumber(_dollarmoney.Get((Object)(_into))));
RDebugUtils.currentLine=327707;
 //BA.debugLineNum = 327707;BA.debugLine="result.Text = NumberFormat(res, minInt, place)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
RDebugUtils.currentLine=327708;
 //BA.debugLineNum = 327708;BA.debugLine="End Sub";
return "";
}
public static String  _length_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "length_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "length_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub Length_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="coinClick = False";
_coinclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="weightClick = False";
_weightclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="lengthClick = True";
_lengthclick = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="transferMain";
_transfermain();
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return "";
}
public static String  _weight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "weight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "weight_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub Weight_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="coinClick = False";
_coinclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="weightClick = True";
_weightclick = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="lengthClick = False";
_lengthclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="transferMain";
_transfermain();
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="End Sub";
return "";
}
}