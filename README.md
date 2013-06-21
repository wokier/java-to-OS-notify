java-to-OS-notify
=================

Java to Operating System Notification

---

Available notifiers :

 - Notify OSD (requires notify-send command to Install with 'sudo apt-get install libnotify-bin' or [Download libnotify](http://archive.ubuntu.com/ubuntu/pool/universe/libn/libnotify4/libnotify-bin_0.7.2-0ubuntu2_amd64.deb) )
 - Growl for Mac OS X [Download Growl](http://growl.info/downloads/) 
 - Snarl [Download Snarl](http://snarl.fullphat.net/)
 - Java 6 System Tray [Get Java](http://www.java.com/fr/download/)


<pre>
╔════════════════════╦═══════╦═════════╦══════════╗
║                    ║ Linux ║ Windows ║ Mac OS X ║
╠════════════════════╬═══════╬═════════╬══════════╣
║ Notify OSD         ║ (X)   ║         ║          ║
║ Growl              ║       ║         ║ (X)      ║
║ Snarl              ║       ║ (X)     ║          ║
║ Java 6 System Tray ║  X    ║  X      ║  X       ║
╚════════════════════╩═══════╩═════════╩══════════╝
</pre>

---

Work in progress : 

 - MacOsX Notification Center
 
 
---

Release Notes :

 - 0.4 2013-06-11 Appengine compatibility & shortcut methods
 - 0.3 2013-03-19 Maven Central Release
 - 0.2 2012-10-12 Bug fixes for Growl and Snarl
 - 0.1 2012-10-05 First Release with 4 different notifiers

