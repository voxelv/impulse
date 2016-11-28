# Impulse #
##### © Tim Slippy - All rights reserved.

## Premise: ##
An impulse will be sent out by a server every hour, on the hour, UTC. 
This impulse can be used to create more impulse.

**Goal:** Amass Impulse.

## Mechanics ##
Impulse is received from an input buffer that can only contain one impulse. If an impulse is received while an impulse still remains in the input buffer, the impulse is forfeited.

Player score is based on an integer impulse count in the score buffer. Only integer amounts of impulse may be input/output to/from the score buffer.

#### Impulse Reception:
An impulse can be received by the player's client (mobile app or client) over a secure connection. A single impulse may also be acquired via a copy-paste-able hexadecimal code sent via SMS or email (for manual entry into the app or client). 

Such manual entry methods may only be received by the [factory](#factory) it is intended for and shall expire after 24 hours.

#### Factory:
* A factory is where a player will construct processes that deal with Ξ and Φ.
* Every factory has an input buffer and a score buffer.
* A factory starts out with a certain number of slots available for [modules](#modules)

#### Factory Management:
* A player may have multiple registered factories.
* Only one may be marked to allow manual impulse entry.
* An unregistered factory shall not receive impulses.
* A player's factories are in-app. They are not backed up by the server. 
* The server shall only send one impulse to each registered factory.
* A player may request one manual-entry impulse per hour for one unregistered factory.
* A factory may be moved (via a compressed zip file) from an app to a pc client or back, and shall be registered for impulse reception at the most recent device.

#### Impulse
Impulse is authorized by the server every hour UTC (as mentioned in the [premise](#premise)). This each time this happens is called a _cycle_.
Two types of impulse exist:

##### Integer Impulse (XI, where X is an integer): Ξ
* Integer impulse is what is what gets populated in the input buffer when an impulse is sent to a [factory](#factory) .
* Integer impulse is also the type of impulse that is scored in the impulse score buffer.

##### Fractional Impulse (FI or PHI): Φ
* Fractional Impulse is what most [modules](#modules) deal with.
* Φ may only stack with Φ of the same value. Eg. you have 0.5Φ and 0.5Φ. This does **not** result in 1Ξ, it is 2x of 0.5Φ.

---

## Modules: ##
Modules shall be available to the player to construct their factory.

##### Module Creation:
Modules are created using recipes of Φ.

e.g. `[0.00625Φ, 0.000125Φ, 0.000125Φ, 0.000125Φ, 0.000000011Φ] -> Impulse Miner 1`

Notice the three instances of 0.000125Φ.

###### Impulse Miner:
* Takes in 1Ξ and outputs 1Ξ and some very small other amount of Φ. Takes multiple cycles to complete this process.

###### Impulse Splitter:
* Splits Ξ into equal amounts of Φ. Balancing shall be done to determine splitting values: 

e.g. `1Ξ -> [0.5Φ, 0.5Φ] vs. 1Ξ -> [0.34Φ, 0.66Φ]`.

###### Impulse Recombinator:
* Combines Φ into Ξ which can then be stored in the score buffer.

###### Impulse Buffer:
* Stores 1Ξ.

###### Impulse Stacker:
* Stores an infinite number of a particular Φ. e.g. 17x 0.0125Φ.
* Will attempt to supply all connected module inputs with the stacked Φ.
* Accepts all incoming Φ as long as it is the correct value.
* If empty, will accept the first Φ value that is offered to it as the new Φ value to accept and provide.

###### Impulse Modulator:
* Can modulate the input buffer to delay each impulse by a certain amount of time.
* Can also be used to change the input Ξ into Φ over time. e.g. 0.2Φ every 12 minutes. In this case, this module behaves like an [Impulse Stacker](#impulse-stacker) with only output.

###### Impulse Dredge:
* Used to delve out space for new modules.

###### Impulse Reactor:
RNG Impulse production:

* 1Ξ input, ?Φ output.
* Net gain over several cycles. Increased output based on symmetry of surrounding modules.
* There shall be rotational and mirror variants.
* Example operation:

`split into 8 cycles, output could be:
1Ξ -> [0.1, 0.1, 0.2, 0.100000001, 0.2, 0.1, 0.1, 0.1]`

###### Impulse Transportation:
* Ξ and Φ shall be moved around by conduits (placeable or meta-linking where modules are simply 'linked'). 
* Connections may only be point-to-point. 
* Modules may have as many connections as needed (or as limited, if limited).

###### Impulse Rounder:
* Special module that rounds any Φ up to a specified nearest Φ value.
* Shall work slowly and/or allowed target Φ value shall be low.
* Higher tier rounders allow higher target Φ.

###### Impulse Builder:
* Builds specific low Φ values into equivalent higher Φ values

e.g. `[0.00125Φ, 0.00875Φ] -> 0.01Φ`

###### Impulse Deconstructor:
* Deconstructs Φ into lower Φ values (basically the reverse of the Impulse Builder).

###### Impulse Drain:
* Drains impulse to oblivion (game keeps track of drained impulse for statistical purposes)

###### Impulse Irradiator:
* Special module that flips the LSB of a Φ. (May be OP, will have to test more)

###### Impulse Detector:
* Module add-on.
* Detects if Ξ or Φ exists in a conduit or module and provides logic signals.

###### Impulse Redirector:
* Redirects impulse based on logic signals.
* Shall enforce point-to-point and make routing somewhat easier.

###### Impulse Requester:
* Special module that requests Φ that may have been missed due to loss of connection with an impulse cycle server.
* Acts like an [Impulse Stacker](#impulse-stacker) but stacks Ξ instead.

###### Impulse Augmentation:
* Module add-on.
* Augments modules to work at different speeds and/or efficiency.

###### Impulse Crystallizer:
* _May not fit the theme anymore due to existence of Φ_
* Crystallizes Ξ into color form for crafting.


---

## Hardcore Techie Mode:
* All Ξ and Φ shall be represented in hexadecimal.

e.g. `0.125Φ decimal is 0.2Φ hexadecimal`

## Competition ##

#### Two contests shall exist as outlined below

##### All-Time:
Factories shall be ranked by the ratio of impulse score per impulses received.
This allows new factory designs to compete with old ones on an even playing field.

##### Near-Time:
Factories shall be ranked by impulse score gain daily, weekly, monthly, and yearly.
This allows burst-y factories to compete with each other.
_(Note: These time measurements shall be measured in constant multiples of hours (cycles). Slight drift will occur with UTC due to leap years, but will not be accounted for. This will add character to the game as time progresses.)_

#### Scoring
Scoring shall count only the integer impulse (Ξ) that is contained in the score buffer. Φ or Ξ elsewhere shall not be counted.

