import React, { useState } from 'react';

type FormProps = {
  onSubmit: (userId: string) => void;
  error: string | null;
};

const Form: React.FC<FormProps> = ({ onSubmit, error }) => {
  const [userId, setUserId] = useState('');

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    onSubmit(userId);
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          <input className='input-field'
            placeholder="Enter your Steam ID"
            type="text"
            value={userId}
            onChange={(event) => setUserId(event.target.value)}
          />
        </label>
        <button className="btn" type="submit">Submit</button>
      </form>
      {error && <div>Error: {error}</div>}
    </div>
  );
};

export default Form;
