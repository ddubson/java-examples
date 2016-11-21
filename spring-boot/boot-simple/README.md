# Deploying

### Heroku

https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku

IMPORTANT: must set `heroku config:set GRADLE_TASK=':spring-boot:boot-simple:stage'` and Procfile in the root project.