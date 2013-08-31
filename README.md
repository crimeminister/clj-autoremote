# clj-autoremote

Use this library to send [AutoRemote](http://joaoapps.com/autoremote/)
messages and notifications to an Android device running
[Tasker](http://tasker.dinglisch.net/) from
[Clojure](http://clojure.org).

## Motivation

The [Tasker](http://tasker.dinglisch.net/) Android application allows users to set up "profiles" that activate when certain conditions are met and to execute "tasks" in response. By installing the [AutoRemote](http://joaoapps.com/autoremote/) plugin for Tasker your Android device is assigned a *device key* and a *personal URL* which, when visited using a web browser, allows you to send:

* *messages* containing an arbitrary text payload
* *notifications* that display in the Android notification tray

Using this library you can send messages and notifications ke from your Clojure programs instead.

## Usage

After you have required the `autoremote` namespace:

```clojure
(require '[org.crimeminister.autoremote :as autoremote])
```

you can send a message using

```clojure
(autoremote/send-message key & args)
```

and a notification using

```clojure
(autoremote/send-notification key & args)
```

In both cases you will require the *device key* for the device you are sending to.

### Obtaining a device key

In order to obtain the AutoRemote key for your Android device you need to obtain the *personal URL* shown on the home activity of the AutoShare plugin:

1. Start the AutoRemote application on your Android device
2. Record the personal URL having format `http://goog.gl/######`

To obtain your device key **manually**:

1. Visit your personal URL in a web browser
2. After being redirected…
3. Copy the value of **key** query parameter in the final URL

To obtain your device key **programmatically**:

1. Call `(autoremote/url-to-key "http://goo.gl/######")`

### Send a message

```clojure
(autoremote/send-message key & args)
```

### Send a notification

```clojure
(autoremote/send-notification key & args)
```

## To Do

* Additional validation checks of message parameters
* Unit tests
* Break out *validateur* validation functions and contribute them back or add to separate validations library

## License

Copyright © 2013 Robert Medeiros

Distributed under the Eclipse Public License, the same as Clojure.
