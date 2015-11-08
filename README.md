# openhab2.elements
This an initial alpha version of an openhab2 binding for gigaset elements.

Current features:
- Things for base, window, door, motion and siren
- Channels for base mode, firmware, battery and positon where applicaple
- Autodiscoery of elements after base is configured
- Autoupdate of channeles every 30 seconds
- Setting of mode via chennel

Known limitations and problems
- Does a login for every api call
- API very verbose in logging
