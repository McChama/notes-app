const deleteNotes = async () => {
    return await fetch(`api/notes/`, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
};

 export default deleteNotes;