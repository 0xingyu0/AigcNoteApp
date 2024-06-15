// src/pages/CreateNote.js
import React from 'react';
import NoteEditor from '../components/NoteEditor';
import api from '../services/api';

const CreateNote = () => {
    const saveNote = async (noteContent) => {
        const response = await api.post('/notes', { content: noteContent });
        console.log(response.data);
    };

    return (
        <div>
            <h1>Create Note</h1>
            <NoteEditor onSave={saveNote} />
        </div>
    );
};

export default CreateNote;
