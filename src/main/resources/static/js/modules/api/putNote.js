const putNote = async note => {
    return await fetch(`api/notes/${note.id}`, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(note)
    })
};
export default putNote;