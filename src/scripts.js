function getEventsList() {
    var pushback_links = $integration.googleSheets.readDataFromCells(
        "9aba963a-f424-4995-abaf-311940e8a58c",
        "1jn48RlKHUWSOLWK7Ymu7WRtwGswhZBAcLrYbHZ5_gwo",
        "EventsList",
        ["A1", "B1", "C1", "D1"]
    );
    
    return events_list;
}