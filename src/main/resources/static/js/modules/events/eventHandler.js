import getNote from "../api/getNote.js";
import newNote from "../views/newNote.js";
import noteForm from "../views/noteForm.js";
import modifyNote from "./modifyNote.js";
import removeNote from "./removeNote.js";
import removeNotes from "./removeNotes.js";
import saveNewNote from "./saveNewNote.js";
import updateNotes from "./updateNotes.js";

const widerScreenWidth = window.matchMedia("(max-width: 500px)");
/* Global events */
const hideSidebar = () => {
    const sidebar = document.getElementById('offcanvasLeft');
    sidebar.style.setProperty('display', 'none', 'important');
}
const showSidebar = () => {
    const sidebar = document.getElementById('offcanvasLeft');
    sidebar.style.setProperty('display', '');
}
/* Sidebar events */
export const disableSidebarButtons = () => {
    const btnDeleteNotes = document.querySelector('#delete-notes');
    const btnRefreshNotes = document.querySelector('#refresh-notes');

    btnDeleteNotes.disabled = true;
    btnRefreshNotes.disabled = true;
}
export const enableSidebarButtons = () => {
    const btnDeleteNotes = document.querySelector('#delete-notes');
    const btnRefreshNotes = document.querySelector('#refresh-notes');

    btnDeleteNotes.disabled = false;
    btnRefreshNotes.disabled = false;
}
const createNote = () => {
    const btnNewNote = document.querySelector('#new-note');
    const noNote = document.querySelector('#no-note');
    btnNewNote.addEventListener('click', () => {
        if (widerScreenWidth.matches) hideSidebar();
        newNote();
        newNoteEvents();
    });
    if (noNote)
        noNote.addEventListener('click', () => {
            if (widerScreenWidth.matches) hideSidebar();
            newNote();
            newNoteEvents();
        });
}
const deleteAllNotes = () => {
    const btnDeleteNotes = document.querySelector('#delete-notes');
    btnDeleteNotes.addEventListener('click', () => removeNotes());
}
const refreshAllNotes = () => {
    const btnRefreshNotes = document.querySelector('#refresh-notes');
    btnRefreshNotes.addEventListener('click', () => updateNotes());
}
const selectNote = () => {
    const noteList = document.querySelectorAll(".list-group-item");
    noteList.forEach(note => {
        note.addEventListener("focus", async e => {
            const note = await getNote(e.target.attributes.value.nodeValue)
            if (widerScreenWidth.matches) hideSidebar();
            noteForm(note);
            noteFormEvents();
            e.target.classList.add("active");
        });
        note.addEventListener("blur", e => e.target.classList.remove("active"));
    });
}

/* Note form events */
const saveNote = () => {
    const btnSave = document.querySelector('#save');
    btnSave.addEventListener('click', () => saveNewNote());
}
const updateNote = () => {
    const btnModify = document.querySelector('#modify');
    btnModify.addEventListener('click', () => modifyNote(btnModify.attributes.value.nodeValue));
}
const deleteNote = () => {
    const btnDelete = document.querySelector('#delete');
    btnDelete.addEventListener('click', () => removeNote(btnDelete.attributes.value.nodeValue));
}
const discardNote = () => {
    const btnDiscard = document.querySelector('#discard');
    btnDiscard.addEventListener('click', () => {
        hideNoteForm();
        showSidebar();
    });
}
const hideNoteForm = () => {
    document.querySelector('#note-form').innerHTML = '';
    document.querySelector('#alerts').innerHTML = '';
}

/* Events loader */
export const createSidebarEvents = () => {
    createNote();
    selectNote();
    deleteAllNotes();
    refreshAllNotes();
}
export const newNoteEvents = () => {
    saveNote();
    discardNote();
}
export const noteFormEvents = () => {
    updateNote();
    deleteNote();
    discardNote();
}
