# clj-autoremote

Use this library to send [AutoRemote](http://joaoapps.com/autoremote/) messages and notifications to an Android device running [Tasker](http://tasker.dinglisch.net/) from [Clojure](http://clojure.org).

## Motivation

The [Tasker](http://tasker.dinglisch.net/) Android application allows users to set up "profiles" that activate when certain conditions are met and to execute "tasks" in response. By installing the [AutoRemote](http://joaoapps.com/autoremote/) plugin for Tasker your Android device is assigned a *device key* and a *personal URL* which, when visited using a web browser, allows you to send:

* *messages* containing an arbitrary text or command payload
* *notifications* that display in the Android notification tray

and to respond to them on the Android device by executing Tasker tasks. Using this library you can send these messages and notifications from your Clojure programs instead.

## Usage

Add this library to your project dependencies:

```clojure
:dependencies [[org.crimeminister/autoremote "0.1.0"]]
```

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

In order to obtain the AutoRemote key for your Android device you need to obtain the *personal URL* shown on the home activity of the AutoRemote plugin:

* Start the AutoRemote application on your Android device
* Record the personal URL having format `http://goog.gl/######`

#### Manually

* Visit your personal URL in a web browser
* After being redirected…
* Copy the value of **key** query parameter in the final URL

#### Programmatically

* Call `(autoremote/url-to-key "http://goo.gl/######")`

### Send a message

To send a message use the `send-message` function:

```clojure
(autoremote/send-message key & args)
```

For example, to send a message containing the string "hello":

```clojure
(autoremote/send-message your-device-key :message "hello")
```

The list of message parameters currently available includes:

* `:message`
* `:target`
* `:sender`
* `:channel`
* `:password`
* `:ttl`

For more detail about the meaning of each parameter please refer to the AutoRemote documentation.

### Send a notification

To send a notification use the `send-notification` function:

```clojure
(autoremote/send-notification key & args)
```

For example, to send a notification with the title "Foo" and content "Bar":

```clojure
(autoremote/send-notification your-device-key :title "Foo" :text "Bar")
```

The list of notification parameters currently available includes:

* `:title`
* `:text`
* `:sound`
* `:vibration`
* `:url`
* `:id`
* `:action`
* `:icon`
* `:led`
* `:ledon`
* `:ledoff`
* `:picture`
* `:message`
* `:action1`
* `:action1name`
* `:action2`
* `:action2name`
* `:action3`
* `:action3name`
* `:sender`

For more detail about the meaning of each parameter please refer to the AutoRemote documentation.

## Responses

If successful, these functions will return a [Ring](https://github.com/ring-clojure/ring)-style response. You can check that the message was correctly sent using the `(autoremote/sent?)` function:

```clojure
(if (autoremote/sent? response)
    (eat-ice-cream)
    (eat-broccoli))
```
or by manually inspecting the `:status` key of the response:

```clojure
(if (= 200 (:status response))
    (ride-unicorn)
    (avoid-dragon))
```

**NB**: just because your message or notification was successfully sent does *not* mean it will be processed by the AutoRemote instance on the Android device. This might happen if, for example, you set a password on the device and forget to send it along with your message or notification.

## Errors

The library uses [Validateur](http://clojurevalidations.info/) to validate incoming data. If there is a problem with the function arguments you supply expect a Validateur-style response, e.g.

```clojure
[false {:foo #{"description of problem with :foo" "another problem with :foo"}}]
```

where the first vector entry is `false` to indicate an error, and the second entry is a map of keys from the map being validated with a corresponding set of error messages describing the problems that were detected.

A validation that is error-free will look like:

```clojure
[true {}]
```

## To Do

* Additional validation checks of message parameters
* Unit tests
* Break out *validateur* validation functions and contribute them back or add to separate validations library

## License

Copyright © 2013 Robert Medeiros

Distributed under the Eclipse Public License, the same as Clojure.
