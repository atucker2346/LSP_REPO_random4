# CRC Cards for ATC System

## CRC Card 1
**Class:** TransponderReceiver

**Responsibilities:**
- Receives high-density packets from aircraft transponders
- Validates incoming packet format
- Forwards valid packets to PacketUnpacker

**Collaborators:**
- PacketUnpacker

**Assumptions:**
- Transponders broadcast packets continuously
- Packets arrive via radio frequency communication

---

## CRC Card 2
**Class:** PacketUnpacker

**Responsibilities:**
- Unpacks high-density packet format
- Extracts aircraft type from packet
- Extracts flight data from packet
- Creates Aircraft objects from unpacked data
- Passes Aircraft objects to AircraftDatabase

**Collaborators:**
- Aircraft
- AircraftDatabase

**Assumptions:**
- Packet format is standardized and known
- Packet contains both aircraft type and flight data

---

## CRC Card 3
**Class:** Aircraft

**Responsibilities:**
- Stores aircraft type
- Stores flight data (position, altitude, speed, heading, etc.)
- Provides accessor methods for aircraft attributes
- Updates flight data when new information arrives

**Collaborators:**
- None (data class)

**Assumptions:**
- Flight data includes position coordinates, altitude, speed, heading
- Aircraft type is a categorical identifier

---

## CRC Card 4
**Class:** AircraftDatabase

**Responsibilities:**
- Stores Aircraft objects
- Retrieves Aircraft objects by identifier
- Updates existing Aircraft objects with new data
- Provides query interface for controller requests
- Maintains collection of all tracked aircraft

**Collaborators:**
- Aircraft
- QueryHandler

**Assumptions:**
- Each aircraft has a unique identifier (e.g., flight number)
- Database operations are thread-safe for concurrent access

---

## CRC Card 5
**Class:** DisplayRenderer

**Responsibilities:**
- Builds graphics display from AircraftDatabase
- Updates display every 10 seconds
- Renders aircraft positions on screen
- Renders aircraft information overlays
- Refreshes display content

**Collaborators:**
- AircraftDatabase

**Assumptions:**
- Display uses graphical coordinate system
- Update interval is exactly 10 seconds
- Display shows all aircraft in database

---

## CRC Card 6
**Class:** DangerDetector

**Responsibilities:**
- Analyzes Aircraft objects for dangerous situations
- Detects proximity violations between aircraft
- Detects altitude conflicts
- Detects potential collisions
- Generates alerts for dangerous situations

**Collaborators:**
- AircraftDatabase

**Assumptions:**
- Dangerous situations include: proximity violations, altitude conflicts, collision risks
- Analysis runs periodically or on data updates
- Safety thresholds are configurable

---

## CRC Card 7
**Class:** QueryHandler

**Responsibilities:**
- Receives controller queries for aircraft details
- Retrieves Aircraft objects from AircraftDatabase
- Formats query results for controller
- Handles queries for aircraft on screen

**Collaborators:**
- AircraftDatabase
- Aircraft

**Assumptions:**
- Controller queries specify aircraft identifier
- Queries are for aircraft currently displayed
- Query results include all relevant aircraft information

---

## CRC Card 8
**Class:** ATCCoordinator

**Responsibilities:**
- Coordinates system startup
- Manages update cycles (10-second display refresh)
- Orchestrates data flow: TransponderReceiver → PacketUnpacker → AircraftDatabase
- Triggers DangerDetector analysis
- Handles system shutdown

**Collaborators:**
- TransponderReceiver
- PacketUnpacker
- AircraftDatabase
- DisplayRenderer
- DangerDetector

**Assumptions:**
- System runs continuously
- Coordinator manages timing for periodic updates
- All components initialized before operation begins
