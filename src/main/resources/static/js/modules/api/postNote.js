const postNote = async (note) => {
    return await fetch('api/notes/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(note)
    })
};
export default postNote;