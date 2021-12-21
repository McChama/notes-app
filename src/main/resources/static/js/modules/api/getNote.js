const getNote = async noteId => {
    return await fetch(`api/notes/${noteId}`)
      .then(response => response.json())
  };

 export default getNote;