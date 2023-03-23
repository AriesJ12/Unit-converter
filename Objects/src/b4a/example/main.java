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
public anywheresoftware.b4a.objects.LabelWrapper _userinp = null;
public anywheresoftware.b4a.objects.LabelWrapper _result = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _moneybef = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _moneyaf = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _massbef = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _massaf = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _distbef = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _distaf = null;
public anywheresoftware.b4a.objects.PanelWrapper _mainframe = null;
public anywheresoftware.b4a.objects.PanelWrapper _startframe = null;
public static boolean _coinclick = false;
public static boolean _weightclick = false;
public static boolean _lengthclick = false;
public static boolean _first = false;
public static boolean _second = false;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="init";
_init();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="userInp.Text = 0";
mostCurrent._userinp.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="result.Text = 0";
mostCurrent._result.setText(BA.ObjectToCharSequence(0));
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="declareList";
_declarelist();
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="changeText";
_changetext();
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="End Sub";
return "";
}
public static String  _init() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "init", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "init", null));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub init 'for loading the layout";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=Fals";
mostCurrent._mainframe.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="mainFrame.Initialize(\"\") : mainFrame.Visible=Fals";
mostCurrent._mainframe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Activity.AddView(mainFrame,0,0,100%x,100%y) 'addv";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._mainframe.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="mainFrame.LoadLayout(\"MainFrame\") ' load";
mostCurrent._mainframe.LoadLayout("MainFrame",mostCurrent.activityBA);
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Tr";
mostCurrent._startframe.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="startFrame.Initialize(\"\") : startFrame.Visible=Tr";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Activity.AddView(startFrame,0,0,100%x,100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._startframe.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="startFrame.LoadLayout(\"StartingFrame\")";
mostCurrent._startframe.LoadLayout("StartingFrame",mostCurrent.activityBA);
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="End Sub";
return "";
}
public static String  _declarelist() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "declarelist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "declarelist", null));}
anywheresoftware.b4a.objects.collections.List _money = null;
anywheresoftware.b4a.objects.collections.List _mass = null;
anywheresoftware.b4a.objects.collections.List _distance = null;
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub declareList";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Dim money As List";
_money = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="money.Initialize2(Array(\"PHP\",\"US Dollar\", \"Yuan\"";
_money.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("PHP"),(Object)("US Dollar"),(Object)("Yuan"),(Object)("Ruble"),(Object)("Euro")}));
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="moneyBef.AddAll(money)";
mostCurrent._moneybef.AddAll(_money);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="moneyAf.AddAll(money)";
mostCurrent._moneyaf.AddAll(_money);
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Dim mass As List";
_mass = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="mass.Initialize2(Array(\"kilogram\", \"gram\", \"pound";
_mass.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("kilogram"),(Object)("gram"),(Object)("pound")}));
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="massBef.AddAll(mass)";
mostCurrent._massbef.AddAll(_mass);
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="massAf.AddAll(mass)";
mostCurrent._massaf.AddAll(_mass);
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="Dim distance As List";
_distance = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="distance.Initialize2(Array(\"kilometer\", \"centimet";
_distance.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)("kilometer"),(Object)("centimeter"),(Object)("meter"),(Object)("foot")}));
RDebugUtils.currentLine=458768;
 //BA.debugLineNum = 458768;BA.debugLine="distBef.AddAll(distance)";
mostCurrent._distbef.AddAll(_distance);
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="distAf.AddAll(distance)";
mostCurrent._distaf.AddAll(_distance);
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="End Sub";
return "";
}
public static String  _changetext() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "changetext", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "changetext", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub changeText";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="If first Then";
if (_first) { 
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="userInp.TextColor = Colors.RGB(0,0,255)";
mostCurrent._userinp.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (0),(int) (255)));
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="userInp.TextSize = 25";
mostCurrent._userinp.setTextSize((float) (25));
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="result.TextColor = Colors.RGB(0,0,0)";
mostCurrent._result.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="result.TextSize = 17";
mostCurrent._result.setTextSize((float) (17));
 }else 
{RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="Else If second Then";
if (_second) { 
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="userInp.TextColor = Colors.RGB(0,0,0)";
mostCurrent._userinp.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (0),(int) (0)));
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="userInp.TextSize = 17";
mostCurrent._userinp.setTextSize((float) (17));
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="result.TextColor = Colors.RGB(0,0,255)";
mostCurrent._result.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (0),(int) (255)));
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="result.TextSize = 25";
mostCurrent._result.setTextSize((float) (25));
 }}
;
RDebugUtils.currentLine=327692;
 //BA.debugLineNum = 327692;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub backImage_Click";
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="mainFrame.Visible = False";
mostCurrent._mainframe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="startFrame.Visible = True";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="userInp.Text = \"0\"";
mostCurrent._userinp.setText(BA.ObjectToCharSequence("0"));
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="result.Text = \"0\"";
mostCurrent._result.setText(BA.ObjectToCharSequence("0"));
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="End Sub";
return "";
}
public static String  _backspace_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "backspace_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "backspace_click", null));}
String _usr = "";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub backspace_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="If first = True Then";
if (_first==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="If userInp.Text = \".\" Then";
if ((mostCurrent._userinp.getText()).equals(".")) { 
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="userInp.Text = \"0\"";
mostCurrent._userinp.setText(BA.ObjectToCharSequence("0"));
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="If userInp.Text = 0 Then";
if ((mostCurrent._userinp.getText()).equals(BA.NumberToString(0))) { 
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="Dim usr As String = userInp.Text.Replace(\",\",\"\")";
_usr = mostCurrent._userinp.getText().replace(",","");
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="If usr.Length > 1 Then 'checks if there is text";
if (_usr.length()>1) { 
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="usr = usr.SubString2(0, usr.Length -1) 'removes";
_usr = _usr.substring((int) (0),(int) (_usr.length()-1));
 }else {
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="usr = \"0\" 'if deleted it will turn into 0";
_usr = "0";
 };
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="userInp.Text = NumberFormat(usr,1,10)";
mostCurrent._userinp.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat((double)(Double.parseDouble(_usr)),(int) (1),(int) (10))));
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="convert";
_convert();
 }else {
RDebugUtils.currentLine=1245205;
 //BA.debugLineNum = 1245205;BA.debugLine="If result.Text = \".\" Then";
if ((mostCurrent._result.getText()).equals(".")) { 
RDebugUtils.currentLine=1245206;
 //BA.debugLineNum = 1245206;BA.debugLine="result.Text = \"0\"";
mostCurrent._result.setText(BA.ObjectToCharSequence("0"));
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1245209;
 //BA.debugLineNum = 1245209;BA.debugLine="If result.Text = 0 Then";
if ((mostCurrent._result.getText()).equals(BA.NumberToString(0))) { 
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1245212;
 //BA.debugLineNum = 1245212;BA.debugLine="Dim usr As String = result.Text.Replace(\",\",\"\")";
_usr = mostCurrent._result.getText().replace(",","");
RDebugUtils.currentLine=1245213;
 //BA.debugLineNum = 1245213;BA.debugLine="If usr.Length > 1 Then 'checks if there is text";
if (_usr.length()>1) { 
RDebugUtils.currentLine=1245214;
 //BA.debugLineNum = 1245214;BA.debugLine="usr = usr.SubString2(0, usr.Length -1) 'removes";
_usr = _usr.substring((int) (0),(int) (_usr.length()-1));
 }else {
RDebugUtils.currentLine=1245217;
 //BA.debugLineNum = 1245217;BA.debugLine="usr = \"0\" 'if deleted it will turn into 0";
_usr = "0";
 };
RDebugUtils.currentLine=1245220;
 //BA.debugLineNum = 1245220;BA.debugLine="result.Text = NumberFormat(usr,1,10)";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat((double)(Double.parseDouble(_usr)),(int) (1),(int) (10))));
RDebugUtils.currentLine=1245222;
 //BA.debugLineNum = 1245222;BA.debugLine="convert";
_convert();
 };
RDebugUtils.currentLine=1245224;
 //BA.debugLineNum = 1245224;BA.debugLine="End Sub";
return "";
}
public static String  _convert() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convert", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convert", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub convert";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="If coinClick = True Then";
if (_coinclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="convertMoney";
_convertmoney();
 }else 
{RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="else if weightClick = True Then";
if (_weightclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="convertMass";
_convertmass();
 }else 
{RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="else if lengthClick = True Then";
if (_lengthclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="convertDist";
_convertdist();
 }}}
;
RDebugUtils.currentLine=1310729;
 //BA.debugLineNum = 1310729;BA.debugLine="End Sub";
return "";
}
public static String  _button0_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button0_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button0_click", null));}
String _number = "";
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub Button0_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Dim const number As String = \"0\"";
_number = "0";
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="End Sub";
return "";
}
public static String  _input(String _number) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "input", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "input", new Object[] {_number}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _usr = null;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub input(number As String)";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="If first = True Then";
if (_first==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="If userInp.Text = 0 And number <> \".\" Then 'chec";
if ((mostCurrent._userinp.getText()).equals(BA.NumberToString(0)) && (_number).equals(".") == false) { 
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="userInp.Text = number 'change the 0 to the inpu";
mostCurrent._userinp.setText(BA.ObjectToCharSequence(_number));
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Return 'exit the process";
if (true) return "";
 };
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="If number = \".\" And userInp.Text.Contains(\".\") T";
if ((_number).equals(".") && mostCurrent._userinp.getText().contains(".")) { 
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="Dim usr As StringBuilder";
_usr = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="usr.Initialize";
_usr.Initialize();
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="usr.Append(userInp.Text.Replace(\",\",\"\")) ' gets";
_usr.Append(mostCurrent._userinp.getText().replace(",",""));
RDebugUtils.currentLine=1048592;
 //BA.debugLineNum = 1048592;BA.debugLine="usr.Append(number) 'add the number that was clic";
_usr.Append(_number);
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="If checkhigh(usr) Then'checks where it is too hi";
if (_checkhigh(BA.ObjectToString(_usr))) { 
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="If number = \".\" Then";
if ((_number).equals(".")) { 
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="userInp.Text = usr";
mostCurrent._userinp.setText(BA.ObjectToCharSequence(_usr.getObject()));
RDebugUtils.currentLine=1048600;
 //BA.debugLineNum = 1048600;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048603;
 //BA.debugLineNum = 1048603;BA.debugLine="userInp.Text = NumberFormat(usr, 1, 10) 'update";
mostCurrent._userinp.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat((double)(BA.ObjectToNumber(_usr)),(int) (1),(int) (10))));
 }else 
{RDebugUtils.currentLine=1048604;
 //BA.debugLineNum = 1048604;BA.debugLine="Else if second = True Then 'same as the statment";
if (_second==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048605;
 //BA.debugLineNum = 1048605;BA.debugLine="If result.Text = 0 And number <> \".\" Then 'check";
if ((mostCurrent._result.getText()).equals(BA.NumberToString(0)) && (_number).equals(".") == false) { 
RDebugUtils.currentLine=1048606;
 //BA.debugLineNum = 1048606;BA.debugLine="result.Text = number 'change the 0 to the input";
mostCurrent._result.setText(BA.ObjectToCharSequence(_number));
RDebugUtils.currentLine=1048607;
 //BA.debugLineNum = 1048607;BA.debugLine="Return 'exit the process";
if (true) return "";
 };
RDebugUtils.currentLine=1048612;
 //BA.debugLineNum = 1048612;BA.debugLine="If number = \".\" And result.Text.Contains(\".\") Th";
if ((_number).equals(".") && mostCurrent._result.getText().contains(".")) { 
RDebugUtils.currentLine=1048613;
 //BA.debugLineNum = 1048613;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048617;
 //BA.debugLineNum = 1048617;BA.debugLine="Dim usr As StringBuilder";
_usr = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1048618;
 //BA.debugLineNum = 1048618;BA.debugLine="usr.Initialize";
_usr.Initialize();
RDebugUtils.currentLine=1048619;
 //BA.debugLineNum = 1048619;BA.debugLine="usr.Append(result.Text.Replace(\",\",\"\")) ' gets t";
_usr.Append(mostCurrent._result.getText().replace(",",""));
RDebugUtils.currentLine=1048620;
 //BA.debugLineNum = 1048620;BA.debugLine="usr.Append(number) 'add the number that was clic";
_usr.Append(_number);
RDebugUtils.currentLine=1048621;
 //BA.debugLineNum = 1048621;BA.debugLine="If checkhigh(usr) Then'checks whether it is too";
if (_checkhigh(BA.ObjectToString(_usr))) { 
RDebugUtils.currentLine=1048622;
 //BA.debugLineNum = 1048622;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048624;
 //BA.debugLineNum = 1048624;BA.debugLine="If number = \".\" Then";
if ((_number).equals(".")) { 
RDebugUtils.currentLine=1048625;
 //BA.debugLineNum = 1048625;BA.debugLine="result.Text = usr";
mostCurrent._result.setText(BA.ObjectToCharSequence(_usr.getObject()));
RDebugUtils.currentLine=1048626;
 //BA.debugLineNum = 1048626;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1048628;
 //BA.debugLineNum = 1048628;BA.debugLine="result.Text = NumberFormat(usr, 1, 10) 'update t";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat((double)(BA.ObjectToNumber(_usr)),(int) (1),(int) (10))));
 }}
;
RDebugUtils.currentLine=1048631;
 //BA.debugLineNum = 1048631;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button1_click", null));}
String _number = "";
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub Button1_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim const number As String = \"1\"";
_number = "1";
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button2_click", null));}
String _number = "";
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub Button2_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim const number As String = \"2\"";
_number = "2";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button3_click", null));}
String _number = "";
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub Button3_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim const number As String = \"3\"";
_number = "3";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="End Sub";
return "";
}
public static String  _button4_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button4_click", null));}
String _number = "";
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub Button4_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Dim const number As String = \"4\"";
_number = "4";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="End Sub";
return "";
}
public static String  _button5_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button5_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button5_click", null));}
String _number = "";
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub Button5_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Dim const number As String = \"5\"";
_number = "5";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="End Sub";
return "";
}
public static String  _button6_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button6_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button6_click", null));}
String _number = "";
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub Button6_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim const number As String = \"6\"";
_number = "6";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="End Sub";
return "";
}
public static String  _button7_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button7_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button7_click", null));}
String _number = "";
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub Button7_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Dim const number As String = \"7\"";
_number = "7";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="End Sub";
return "";
}
public static String  _button8_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button8_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button8_click", null));}
String _number = "";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub Button8_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Dim const number As String = \"8\"";
_number = "8";
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="End Sub";
return "";
}
public static String  _button9_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "button9_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "button9_click", null));}
String _number = "";
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub Button9_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim const number As String = \"9\"";
_number = "9";
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="End Sub";
return "";
}
public static String  _buttonclear_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttonclear_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttonclear_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub Buttonclear_Click";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="userInp.Text = \"0\"";
mostCurrent._userinp.setText(BA.ObjectToCharSequence("0"));
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="result.Text = \"0\"";
mostCurrent._result.setText(BA.ObjectToCharSequence("0"));
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="convert";
_convert();
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="End Sub";
return "";
}
public static String  _buttondot_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "buttondot_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "buttondot_click", null));}
String _number = "";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub Buttondot_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="Dim number As String = \".\" 'adds a dot";
_number = ".";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="input(number)";
_input(_number);
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkhigh(String _usr) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "checkhigh", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "checkhigh", new Object[] {_usr}));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub checkhigh(usr As String) As Boolean";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="If usr > 2000000000 Or usr < -2000000000 Then";
if ((double)(Double.parseDouble(_usr))>2000000000 || (double)(Double.parseDouble(_usr))<-2000000000) { 
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="ToastMessageShow(\"input/output is too high\", Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("input/output is too high"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="If first = True Then";
if (_first==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="If userInp.Text.Replace(\",\",\"\") > 2000000000 Or";
if ((double)(Double.parseDouble(mostCurrent._userinp.getText().replace(",","")))>2000000000 || (double)(Double.parseDouble(mostCurrent._userinp.getText().replace(",","")))<-2000000000) { 
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="ToastMessageShow(\"input/output is too high\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("input/output is too high"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="Else if result.Text.Replace(\",\",\"\") > 2000000000";
if ((double)(Double.parseDouble(mostCurrent._result.getText().replace(",","")))>2000000000 || (double)(Double.parseDouble(mostCurrent._result.getText().replace(",","")))<-2000000000) { 
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="ToastMessageShow(\"input/output is too high\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("input/output is too high"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }}
;
 };
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4259855;
 //BA.debugLineNum = 4259855;BA.debugLine="End Sub";
return false;
}
public static String  _coin_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "coin_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "coin_click", null));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Private Sub coin_Click";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="coinClick = True";
_coinclick = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="weightClick = False";
_weightclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="lengthClick = False";
_lengthclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="transferMain";
_transfermain();
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return "";
}
public static String  _transfermain() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "transfermain", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "transfermain", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub transferMain";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="startFrame.Visible = False";
mostCurrent._startframe.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="mainFrame.Visible = True";
mostCurrent._mainframe.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="If coinClick = True Then";
if (_coinclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="moneyBef.Visible = True";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="moneyAf.Visible = True";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="Else If weightClick = True Then";
if (_weightclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="moneyBef.Visible = False";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="moneyAf.Visible = False";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="massBef.Visible = True";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="massAf.Visible = True";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917526;
 //BA.debugLineNum = 917526;BA.debugLine="distBef.Visible = False";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917527;
 //BA.debugLineNum = 917527;BA.debugLine="distAf.Visible = False";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else 
{RDebugUtils.currentLine=917530;
 //BA.debugLineNum = 917530;BA.debugLine="Else If lengthClick = True Then";
if (_lengthclick==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=917531;
 //BA.debugLineNum = 917531;BA.debugLine="moneyBef.Visible = False";
mostCurrent._moneybef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917532;
 //BA.debugLineNum = 917532;BA.debugLine="moneyAf.Visible = False";
mostCurrent._moneyaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="massBef.Visible = False";
mostCurrent._massbef.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917535;
 //BA.debugLineNum = 917535;BA.debugLine="massAf.Visible = False";
mostCurrent._massaf.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=917537;
 //BA.debugLineNum = 917537;BA.debugLine="distBef.Visible = True";
mostCurrent._distbef.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=917538;
 //BA.debugLineNum = 917538;BA.debugLine="distAf.Visible = True";
mostCurrent._distaf.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }}}
;
RDebugUtils.currentLine=917541;
 //BA.debugLineNum = 917541;BA.debugLine="End Sub";
return "";
}
public static String  _convertmoney() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convertmoney", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convertmoney", null));}
String _from = "";
String _into = "";
anywheresoftware.b4a.objects.collections.Map _dollarmoney = null;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub convertMoney";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="from = moneyBef.SelectedItem 'get selected item";
_from = mostCurrent._moneybef.getSelectedItem();
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="into = moneyAf.SelectedItem";
_into = mostCurrent._moneyaf.getSelectedItem();
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="Dim dollarMoney As Map";
_dollarmoney = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="dollarMoney.Initialize";
_dollarmoney.Initialize();
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="dollarMoney.Put(\"PHP\", 54.91)";
_dollarmoney.Put((Object)("PHP"),(Object)(54.91));
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="dollarMoney.Put(\"US Dollar\", 1.00)";
_dollarmoney.Put((Object)("US Dollar"),(Object)(1.00));
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="dollarMoney.Put(\"Yuan\", 6.90)";
_dollarmoney.Put((Object)("Yuan"),(Object)(6.90));
RDebugUtils.currentLine=524304;
 //BA.debugLineNum = 524304;BA.debugLine="dollarMoney.Put(\"Ruble\", 76.26)";
_dollarmoney.Put((Object)("Ruble"),(Object)(76.26));
RDebugUtils.currentLine=524305;
 //BA.debugLineNum = 524305;BA.debugLine="dollarMoney.Put(\"Euro\", 0.94)";
_dollarmoney.Put((Object)("Euro"),(Object)(0.94));
RDebugUtils.currentLine=524307;
 //BA.debugLineNum = 524307;BA.debugLine="mainConvert(dollarMoney.Get(from), dollarMoney.Ge";
_mainconvert((double)(BA.ObjectToNumber(_dollarmoney.Get((Object)(_from)))),(double)(BA.ObjectToNumber(_dollarmoney.Get((Object)(_into)))));
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="End Sub";
return "";
}
public static String  _convertmass() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convertmass", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convertmass", null));}
String _from = "";
String _into = "";
anywheresoftware.b4a.objects.collections.Map _mass = null;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub convertMass";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="from = massBef.SelectedItem";
_from = mostCurrent._massbef.getSelectedItem();
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="into = massAf.SelectedItem";
_into = mostCurrent._massaf.getSelectedItem();
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="Dim mass As Map";
_mass = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="mass.Initialize";
_mass.Initialize();
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="mass.Put(\"kilogram\", 0.001)";
_mass.Put((Object)("kilogram"),(Object)(0.001));
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="mass.Put(\"gram\", 1.00)";
_mass.Put((Object)("gram"),(Object)(1.00));
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="mass.Put(\"pound\", 0.00220462)";
_mass.Put((Object)("pound"),(Object)(0.00220462));
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="mainConvert(mass.Get(from), mass.Get(into))";
_mainconvert((double)(BA.ObjectToNumber(_mass.Get((Object)(_from)))),(double)(BA.ObjectToNumber(_mass.Get((Object)(_into)))));
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="End Sub";
return "";
}
public static String  _convertdist() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "convertdist", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "convertdist", null));}
String _from = "";
String _into = "";
anywheresoftware.b4a.objects.collections.Map _distance = null;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub convertDist";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Dim from As String";
_from = "";
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="from = distBef.SelectedItem";
_from = mostCurrent._distbef.getSelectedItem();
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Dim into As String";
_into = "";
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="into = distAf.SelectedItem";
_into = mostCurrent._distaf.getSelectedItem();
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="Dim distance As Map";
_distance = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="distance.Initialize";
_distance.Initialize();
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="distance.Put(\"kilometer\", 0.001)";
_distance.Put((Object)("kilometer"),(Object)(0.001));
RDebugUtils.currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="distance.Put(\"centimeter\", 100.00)";
_distance.Put((Object)("centimeter"),(Object)(100.00));
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="distance.Put(\"meter\", 1.00)";
_distance.Put((Object)("meter"),(Object)(1.00));
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="distance.Put(\"foot\", 3.28084)";
_distance.Put((Object)("foot"),(Object)(3.28084));
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="mainConvert(distance.Get(from), distance.Get(into";
_mainconvert((double)(BA.ObjectToNumber(_distance.Get((Object)(_from)))),(double)(BA.ObjectToNumber(_distance.Get((Object)(_into)))));
RDebugUtils.currentLine=655377;
 //BA.debugLineNum = 655377;BA.debugLine="End Sub";
return "";
}
public static String  _mainconvert(double _from,double _into) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mainconvert", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "mainconvert", new Object[] {_from,_into}));}
int _place = 0;
int _minint = 0;
double _usr = 0;
double _res = 0;
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub mainConvert(from As Double, into As Double)";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Dim const place As Int = 15";
_place = (int) (15);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Dim const minInt As Int = 1";
_minint = (int) (1);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="If first = True Then";
if (_first==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Dim usr As Double = userInp.Text.Replace(\",\",\"\")";
_usr = (double)(Double.parseDouble(mostCurrent._userinp.getText().replace(",","")));
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="Dim res As Double = usr/from * (into)";
_res = _usr/(double)_from*(_into);
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="result.Text = NumberFormat(res,minInt, place)'di";
mostCurrent._result.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
 }else 
{RDebugUtils.currentLine=3604494;
 //BA.debugLineNum = 3604494;BA.debugLine="Else if second = True Then 'same as the statment";
if (_second==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3604496;
 //BA.debugLineNum = 3604496;BA.debugLine="Dim usr As Double = result.Text.Replace(\",\",\"\")";
_usr = (double)(Double.parseDouble(mostCurrent._result.getText().replace(",","")));
RDebugUtils.currentLine=3604500;
 //BA.debugLineNum = 3604500;BA.debugLine="Dim res As Double = usr/into * from";
_res = _usr/(double)_into*_from;
RDebugUtils.currentLine=3604501;
 //BA.debugLineNum = 3604501;BA.debugLine="userInp.Text = NumberFormat(res,minInt, place)";
mostCurrent._userinp.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.NumberFormat(_res,_minint,_place)));
 }}
;
RDebugUtils.currentLine=3604503;
 //BA.debugLineNum = 3604503;BA.debugLine="End Sub";
return "";
}
public static String  _length_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "length_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "length_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub Length_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="coinClick = False";
_coinclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="weightClick = False";
_weightclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="lengthClick = True";
_lengthclick = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="transferMain";
_transfermain();
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="End Sub";
return "";
}
public static String  _result_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "result_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "result_click", null));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Private Sub result_Click";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="first = False";
_first = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="second = True";
_second = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="changeText";
_changetext();
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="End Sub";
return "";
}
public static String  _userinp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "userinp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "userinp_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub userInp_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="first = True";
_first = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="second = False";
_second = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="changeText";
_changetext();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="End Sub";
return "";
}
public static String  _weight_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "weight_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "weight_click", null));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub Weight_Click";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="coinClick = False";
_coinclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="weightClick = True";
_weightclick = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="lengthClick = False";
_lengthclick = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="transferMain";
_transfermain();
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="End Sub";
return "";
}
}