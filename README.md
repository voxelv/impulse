# Impulse #
##### © Tim Slippy, voxelv - All rights reserved.

## Premise: ##
An impulse will be generated every hour, on the hour, UTC. This impulse can be used to create more impulse.

**Goal:** Amass Impulse.

## Mechanics ##
Impulse is received from the input buffer. The input buffer can only contain one impulse at a time.

### Scoring
Scoring shall count only the integer impulse (Ξ) that is contained in the score buffer. Φ or Ξ elsewhere shall not be counted.  
Player score is based on an integer impulse count in the score buffer.  
Only integer amounts of impulse may be input/output to/from the score buffer.

### Factory:
* A factory is where the player will construct processes that deal with impulse.
* Every factory has one input buffer and a score buffer.
* A factory starts out with a certain number of slots available for [modules](#modules)

### Factory Management:
* The player may have multiple factories.

### Impulse
An impulse occurs every hour (as mentioned in the [premise](#premise)). Each time this happens is called a _cycle_.  
Impulse is the only resource in the game.

#### Two types of impulse exist:

##### Integer Impulse (XI, where X is an integer): Ξ
* Integer impulse is what is what gets populated in the input buffer when an impulse is sent to a [factory](#factory) .
* Integer impulse is also the type of impulse that is scored in the impulse score buffer.

##### Fractional Impulse (FI or PHI): Φ
* Fractional Impulse is what _most_ [modules](#modules) deal with.
* Φ may only stack with Φ of the same value. Eg. you have 0.5Φ and 0.5Φ. This does **not** result in 1Ξ, it is 2x of 0.5Φ, i.e. `[0.5Φ, 0.5Φ]`.
* Look into "fixnums", or possibly represented by a pair of integers (numerator/denominator).

#### Impulse Transportation:
Connections may only be point-to-point. 
Modules may have as many connections as needed (or as limited, if limited).

* Two possible implementations:
    1. Conduits: 
        * Ξ and Φ shall be moved around by conduits that can be placed.
        * Perhaps "click-and-drag" creation, where conduits are created as the cursor moves into each grid space, or deleted if on the same click if the cursor moves out of a grid space.
        * The cost would only be one "Conduit" per connection line.
    2. Meta-Linking:
        * Modules are simply 'linked', but not visually or with a conduit.
        * The conduits would be in "the space between the grid".
        * This would require a way to "print out" or "visualize" the factory layout.
        * This would make complex factories not only possible, but easy to make (perhaps too easy).

---

## Modules: ##
Modules shall be available to the player to construct their factory.

### Module Creation:
Modules are created using recipes of Φ.

e.g. `[0.00625Φ, 0.000125Φ, 0.000125Φ, 0.000125Φ, 0.000000011Φ] -> Impulse Miner 1`

Notice the three instances of 0.000125Φ.

### Module List:

#### Impulse Miner:
* Takes in 1Ξ and outputs 1Ξ and some very small amount of Φ. 
* Takes multiple cycles to complete this process.

#### Impulse Splitter:
* Splits Ξ into equal amounts of Φ. 
* Balancing shall be done to determine splitting values: 

  e.g. `1Ξ -> [0.5Φ, 0.5Φ] vs. 1Ξ -> [0.34Φ, 0.66Φ]`.

#### Impulse Recombinator:
Combines Φ into Ξ which can then be stored in the score buffer.

* Two possible implementations:
  * Store Φ until a total of 1.0Φ (or slightly more) is contained then convert it into 1Ξ.
    * Perhaps this process costs an extra amount of Φ.
  * Exact input to output conversion (The opposite of the [Impulse Splitter](#impulse-splitter))
    * Each module would have different input Φ values, assignable by connection.

#### Impulse Buffer:
* Stores 1Ξ.

#### Impulse Stacker:
* Stores an infinite number of a particular Φ. e.g. 17x 0.0125Φ.
* Will attempt to supply all connected module inputs with the stacked Φ.
* Accepts all incoming Φ as long as it is the correct value.
* If empty, will accept the first Φ value that is offered to it as the new Φ value to accept and provide.

#### Impulse Dredge:
* Used to delve out factory walls to create space for more modules.

#### Impulse Builder:
* Builds specific low Φ values into equivalent higher Φ values

e.g. `[0.00125Φ, 0.00875Φ] -> 0.01Φ`

#### Impulse Deconstructor:
* Deconstructs Φ into lower Φ values (basically the reverse of the Impulse Builder).

#### Impulse Drain:
* Drains impulse to oblivion (game keeps track of drained impulse for statistical purposes)

---
##### © Tim Slippy, voxelv - All rights reserved.