export const deleteDataFrom =  async uri => {
  return await _handlerFetch({ method: 'DELETE', uri });
}

export const getDataFrom = async uri => {
  const response = await fetch(uri);
  const data = await response.json();

  return data;
};

export const putDataFrom = async uri => {
  return await _handlerFetch({ method: 'PUT', uri });
}

export const postDataFrom = async (uri, body = {}) => {
  return await _handlerFetch({ args: { body }, method: 'POST', uri })
}

const _DEFAULT_HEADERS = {
  'Accept': 'application/json',
  'Content-Type': 'application/json',
};

const _DEFAULT_METHOD = 'GET';

const _handlerFetch = ({ args = {}, headers = _DEFAULT_HEADERS, method = _DEFAULT_METHOD, uri }) => {
  return fetch(uri, { ...args, method, headers })
};
