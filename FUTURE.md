# Future Ideas. 2.0 may contain these changes: #

## Server-Sends-Impulse Implementation ##

### Premise: ###
An impulse will be sent out by a server every hour, on the hour, UTC. This impulse can be used to create more impulse.

**Goal:** Amass Impulse.

### Mechanics ###
Impulse is received from the input buffer. The input buffer can only contain one impulse. If an impulse is received while an impulse still remains in the input buffer, the new impulse is forfeited.

Player score is based on an integer impulse count in the score buffer. Only integer amounts of impulse may be input/output to/from the score buffer.

#### Impulse Reception:
An impulse can be received by the player's client (mobile app or client) over a secure connection. A single impulse may also be acquired via a copy-paste-able hexadecimal code sent via SMS or email (for manual entry into the app or client). 

Such manual entry methods may only be received by the [factory](#factory) it is intended for and shall expire after 24 hours.

#### Factory:
* A factory is where the player will construct processes that deal with impulse.
* Every factory has one input buffer and a score buffer.
* A factory starts out with a certain number of slots available for [modules](#modules)
* Factories must be registered with the server to receive impulse (or manual entry).

#### Factory Management:
* The player may have multiple registered factories.
* Only one may be marked to allow manual impulse entry.
* An unregistered factory shall not receive impulses.
* The player's factories are in-app. They are not backed up by the server. 
* The server shall only send one impulse to each registered factory.
* The player may request one manual-entry impulse per hour for one unregistered factory.
* A factory may be moved (via a compressed zip file) from an app to a pc client or back, and shall be registered for impulse reception at the most recent device.


## Hardcore Techie Mode: ##
* All Ξ and Φ shall be represented in hexadecimal.

e.g. `0.125Φ decimal is 0.2Φ hexadecimal`


## Programmable Logic, Add-On Modules, and other Modules: ##
**Programmable Logic**: a separate type of connection used for control instead of impulse flow.
**Add-On Modules**: like modules that fit inside a regular module.
**Other Modules**: additional modules.

#### Impulse Detector:
* Module add-on.
* Detects if Ξ or Φ exists in a conduit or module and provides logic signals.

#### Impulse Augmentation:
* Module add-on.
* Augments modules to work at different speeds and/or efficiency.

#### Impulse Redirector:
* Redirects impulse based on logic signals.
* Shall enforce point-to-point and make routing somewhat easier.

#### Impulse Modulator:
* Can modulate the input buffer to delay each impulse by a certain amount of time.
* Can also be used to change the input Ξ into Φ over time. e.g. 0.2Φ every 12 minutes. In this case, this module behaves like an [Impulse Stacker](#impulse-stacker) with only output.

#### Impulse Reactor:
RNG Impulse production:

* 1Ξ input, ?Φ output.
* Net gain over several cycles. Increased output based on symmetry of surrounding modules.
* There shall be rotational and mirror variants.
* Example operation:

  `split into 8 cycles, output could be:
  1Ξ -> [0.1Φ, 0.1Φ, 0.2Φ, 0.2Φ, 0.2Φ, 0.1Φ, 0.1Φ, 0.1Φ]`

#### Impulse Rounder:
* Special module that rounds any Φ up to a specified nearest Φ value.
* Shall work slowly and/or allowed target Φ value shall be low.
* Higher tier rounders allow higher target Φ.

#### Impulse Irradiator:
* Special module that flips the LSB of a Φ. (May be OP, will have to test more)

#### Impulse Requester:
* Special module that requests Ξ that may have been previously forfeited.
* Acts like an [Impulse Stacker](#impulse-stacker) but stacks Ξ instead.

#### Impulse Crystallizer:
* _May not fit the theme anymore due to existence of Φ_
* _This entry is kept for name and possible functional purposes_
* Crystallizes Ξ into color form for crafting.

#### Impulse Sub-Factory:
* Factory-ception. A grid that compresses space (perhaps even space-time). 
* This would need to be fleshed out as to how things would even work with it.
* It sounds cool though.


## Player Factory Competition ##

#### Two contests shall exist as outlined below

##### All-Time:
Factories shall be ranked by the ratio of impulse score per impulses received.
This allows new factory designs to compete with old ones on an even playing field.

##### Near-Time:
Factories shall be ranked by impulse score gain daily, weekly, monthly, and yearly.
This allows burst-y factories to compete with each other.
_(Note: These time measurements shall be measured in constant multiples of hours (cycles). Slight drift will occur with UTC due to leap years, but will not be accounted for. This will add character to the game as time progresses.)_


## Colored Impulse ##
Originally, colored impulse was to be the different kinds of impulse. Now there is Φ. Colored impulse could still be a thing, each impulse could have a different color, on a 24-cycle revolution. This would help for debugging a factory. Hour 0 through 23 could determine hue from 0.0 to 1.0. Or perhaps on a 6-cycle revolution: RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA.
### Colored Impulse Ideas ###
* Modules could get bonuses for having only processed one color
* There could be a module that filters different colors.
* There could be a "contamination" mechanic where colors can mix and cause some specialized modules to become "clogged" (Thus creating a good use for an [Impulse Drain](#impulse-drain)).

---
##### © Tim Slippy, voxelv - All rights reserved.