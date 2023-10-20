
// oidc-config.ts

import { OidcClientSettings, UserManager } from 'oidc-client-ts';

const oidcConfig: OidcClientSettings = {
  authority: 'http://localhost:9000/', // Replace with your OIDC provider's URL
  client_id: 'client', // Replace with your OIDC client ID
  client_secret:'secret',
  client_authentication:'client_secret_basic',
  redirect_uri: 'http://localhost:8090/auth', // Replace with your redirect URI
  scope: 'openid',
};

export default oidcConfig;
const userManager=new UserManager(oidcConfig);
export {userManager};
