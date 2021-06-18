FROM node:12.16.3
WORKDIR /appfront
COPY package.json /appfront
RUN npm install
COPY . .
CMD ["npm", "start"]