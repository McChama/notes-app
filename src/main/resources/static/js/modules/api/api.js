import { deleteDataFrom, getDataFrom, postDataFrom, putDataFrom } from "../utils/network.js";

class API_NOTES {
  constructor () {
    if (API_NOTES.instance) return API_NOTES.instance

    API_NOTES.instance = this
    this.base_uri = 'api/notes/'
    this.bulkUpdate_notes_uri = 'api/bulkUpdate/notes/'
  }

  getNote = async noteId => {
    return await getDataFrom(`${this.base_uri}${noteId}`);
  }

  getNotes = async () => {
    return await getDataFrom(this.base_uri);
  };

  deleteNote = async noteId => {
    return await deleteDataFrom(`${this.base_uri}${noteId}`);
  };

  deleteNotes = async () => {
    return await deleteDataFrom(this.base_uri)
  };

  putNote = async (note) => {
    const noteInJSON = JSON.stringify(note);
    return await putDataFrom(`${this.base_uri}${noteId}`, noteInJSON);
  };

  putNotes = async () => {
    return await putDataFrom(this.bulkUpdate_notes_uri)
  };

  postNote = async (note) => {
    const noteInJSON = JSON.stringify(note);
    return await postDataFrom(this.base_uri, noteInJSON);
  };
};

const API = new API_NOTES;

export default API
