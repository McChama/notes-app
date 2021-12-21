const deleteNote = async noteId => {
    return await fetch(`api/notes/${noteId}`, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
};

 export default deleteNote;