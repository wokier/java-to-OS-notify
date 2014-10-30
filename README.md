java-to-OS-notify
=================

Java to Operating System Notification

"Write Once, Notify Everywhere"
-------------------------------

Allows to display a notification which pops and disappears, using the appropriate notification system.

---

Available notifiers :

|                    | Linux  | Windows | Mac OS X |
|--------------------|:------:|:-------:|:--------:|
| Notify OSD         | (X)    |         |          |
| Growl              |        |         | (X)      |
| Mac OS X Center    |        |         | (X)      |
| Snarl              |        | (X)     |          |
| Java 6 System Tray |  X     |  X      |  X       |
| Java Logging       |  X     |  X      |  X       |


 - Notify OSD ( Requires notify-send command to Install with 'sudo apt-get install libnotify-bin' or [Download libnotify](http://archive.ubuntu.com/ubuntu/pool/universe/libn/libnotify4/libnotify-bin_0.7.2-0ubuntu2_amd64.deb) )
 - Growl for Mac OS X ( Install from the Apple App Store or [Download Growl](http://growl.info/downloads/) )
 - Mac OS X Notification Center ( Requires [Terminal Notifier](https://github.com/alloy/terminal-notifier) to Install with 'brew install terminal-notifier'  and [Mountain Lion](https://support.apple.com/kb/HT5362) )
 - Snarl ( [Download Snarl](http://snarl.fullphat.net/) )
 - Java 6 System Tray
 - Java Util Logging (always used)
 
---

Release Notes :

 - 0.6 2013-11-24 Bug fixes #2 and #3
 - 0.5 2013-08-28 Growl 1.3 compatibility & MacOsX Notification Center
 - 0.4 2013-06-11 Appengine compatibility & shortcut methods
 - 0.3 2013-03-19 Maven Central Release
 - 0.2 2012-10-12 Bug fixes for Growl and Snarl
 - 0.1 2012-10-05 First Release with 4 different notifiers
 
---

Used in

https://github.com/wokier/progress-maven-plugin

https://github.com/wokier/notify-test-progress
 

