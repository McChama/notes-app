import getNotes from "./modules/api/getNotes.js";
import { createSidebarEvents } from "./modules/events/eventHandler.js";
import { createSidebarHTML } from "./modules/events/htmlHandler.js";

/* Get notes list from API */
const NOTES = await getNotes();

/* Then create a sidebar with the notes list */
createSidebarHTML(NOTES);
createSidebarEvents();