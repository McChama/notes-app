const getNotes = async () => {
  return await fetch(`api/notes/`)
    .then(response => response.json())
};

export default getNotes;