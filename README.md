# ValueCraft PoC

ValueCraft is an early stage project, aiming at supporting
community currencies on the top of
[Trustlines network](http://trustlines.newtwork).

This repository contains an early stage proof of concept
ValueCraft user interface for ValueCraft.  The beginnings
is an Android WebView wrapper that is able to run the
Trustlines network PoC Webapp within an Android app.
Our goal is to gradually move features from the Webapp
to the Android side.

To get started, you need to have access to the
Trustlines network PoC.  At this writing it is still in
alpha, basically meaning that you have to get an invitation
from someone involved.

Once you have Trustlines PoC access, you can start
playing with the ValueCraft PoC code.

## Installation instructions

1. Clone and build the ValueCraft Android app
2. Install and launch the app on your Android phone
3. Enter your Trustlines PoC prefix (first time only)
4. Pair with other people and try the app out

### Command line

```
git clone https://github.com/valuecraft/ValueCraft.git
gradle build
gradle installDebug
adb shell am start -n fi.iki.pnr.valuecraft.valuecraft/.MainActivity
```

### Android Studio

Preferably, first create a
[Personal access token](https://github.com/settings/tokens)
at Github (you need repo rights) and
configure it to your Android Studio at
`Preferences...→Version Control→Github`.  Alternatively, you
can use your Github username and password...

Download the project from Github:
`File→New→Project from Version Control→GitHub`

| Field              | Value                                        |
|--------------------|----------------------------------------------|
| Git Repository URL | https://github.com/valuecraft/ValueCraft.git |
| Parent Directory   | _use default value_                          |
| Directory name     | _your choice_, e.g. `ValueCraft`             |

Then simply build and run it: `Run→Run 'app' ^R`

### Enter your Trustlines PoC

Once you have successfully launched the app in your Android device
or emulator, for the first run the app asks for your Trustlines
PoC prefix.  If you don't have one, you cannot use the app.

### Pair with others and use

Instructions TBD
