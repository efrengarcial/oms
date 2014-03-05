'use strict';

define(["angular","controllers"], function(angular,controllers){
    /* Services Module */
   
    controllers.directive('ccImgPerson', ['config', function (config) {
        //Usage:
        //<img data-cc-img-person="{{s.speaker.imageSource}}"/>
        var basePath = config.imageSettings.imageBasePath;
        var unknownImage = config.imageSettings.unknownPersonImageSource;
        var directive = {
            link: link,
            restrict: 'A'
        };
        return directive;

        function link(scope, element, attrs) {
            attrs.$observe('ccImgPerson', function(value) {
                value = basePath + (value || unknownImage);
                attrs.$set('src', value);
            });
        }
    }]);


    controllers.directive('ccSidebar', function () {
        // Opens and clsoes the sidebar menu.
        // Usage:
        //  <div data-cc-sidebar>
        // Creates:
        //  <div data-cc-sidebar class="sidebar">
        var directive = {
            link: link,
            restrict: 'A'
        };
        return directive;

        function link(scope, element, attrs) {
            var $sidebarInner = element.find('.sidebar-inner');
            var $dropdownElement = element.find('.sidebar-dropdown a');
            element.addClass('sidebar');
            $dropdownElement.click(dropdown);

            function dropdown(e) {
                var dropClass = 'dropy';
                e.preventDefault();
                if (!$dropdownElement.hasClass(dropClass)) {
                    hideAllSidebars();
                    $sidebarInner.slideDown(350);
                    $dropdownElement.addClass(dropClass);
                } else if ($dropdownElement.hasClass(dropClass)) {
                    $dropdownElement.removeClass(dropClass);
                    $sidebarInner.slideUp(350);
                }

                function hideAllSidebars() {
                    $sidebarInner.slideUp(350);
                    $('.sidebar-dropdown a').removeClass(dropClass);
                }
            }
        }
    });


    controllers.directive('ccWidgetClose', function () {
        // Usage:
        // <a data-cc-widget-close></a>
        // Creates:
        // <a data-cc-widget-close="" href="#" class="wclose">
        //     <i class="fa fa-remove"></i>
        // </a>
        var directive = {
            link: link,
            template: '<i class="fa fa-remove"></i>',
            restrict: 'A'
        };
        return directive;

        function link(scope, element, attrs) {
            attrs.$set('href', '#');
            attrs.$set('wclose');
            element.click(close);

            function close(e) {
                e.preventDefault();
                element.parent().parent().parent().hide(100);
            }
        }
    });

    controllers.directive('ccWidgetMinimize', function () {
        // Usage:
        // <a data-cc-widget-minimize></a>
        // Creates:
        // <a data-cc-widget-minimize="" href="#"><i class="fa fa-chevron-up"></i></a>
        var directive = {
            link: link,
            template: '<i class="fa fa-chevron-up"></i>',
            restrict: 'A'
        };
        return directive;

        function link(scope, element, attrs) {
            //$('body').on('click', '.widget .wminimize', minimize);
            attrs.$set('href', '#');
            attrs.$set('wminimize');
            element.click(minimize);

            function minimize(e) {
                e.preventDefault();
                var $wcontent = element.parent().parent().next('.widget-content');
                var iElement = element.children('i');
                if ($wcontent.is(':visible')) {
                    iElement.removeClass('fa fa-chevron-up');
                    iElement.addClass('fa fa-chevron-down');
                } else {
                    iElement.removeClass('fa fa-chevron-down');
                    iElement.addClass('fa fa-chevron-up');
                }
                $wcontent.toggle(500);
            }
        }
    });

    controllers.directive('ccScrollToTop', ['$window',
        // Usage:
        // <span data-cc-scroll-to-top></span>
        // Creates:
        // <span data-cc-scroll-to-top="" class="totop">
        //      <a href="#"><i class="fa fa-chevron-up"></i></a>
        // </span>
        function ($window) {
            var directive = {
                link: link,
                template: '<a href="#"><i class="fa fa-chevron-up"></i></a>',
                restrict: 'A'
            };
            return directive;

            function link(scope, element, attrs) {
                var $win = $($window);
                element.addClass('totop');
                $win.scroll(toggleIcon);

                element.find('a').click(function (e) {
                    e.preventDefault();
                    // Learning Point: $anchorScroll works, but no animation
                    //$anchorScroll();
                    $('body').animate({ scrollTop: 0 }, 500);
                });

                function toggleIcon() {
                    $win.scrollTop() > 300 ? element.slideDown(): element.slideUp();
                }
            }
        }
    ]);

    controllers.directive('ccSpinner', ['$window', function ($window) {
        // Description:
        //  Creates a new Spinner and sets its options
        // Usage:
        //  <div data-cc-spinner="vm.spinnerOptions"></div>
        var directive = {
            link: link,
            restrict: 'A'
        };
        return directive;

        function link(scope, element, attrs) {
            scope.spinner = null;
            scope.$watch(attrs.ccSpinner, function (options) {
                if (scope.spinner) {
                    scope.spinner.stop();
                }
                scope.spinner = new $window.Spinner(options);
                scope.spinner.spin(element[0]);
            }, true);
        }
    }]);

    controllers.directive('ccWidgetHeader', function() {
        //Usage:
        //<div data-cc-widget-header title="vm.map.title"></div>
        var directive = {
            link: link,
            scope: {
                'title': '@',
                'subtitle': '@',
                'rightText': '@',
                'allowCollapse': '@'
            },
            templateUrl: 'app/layout/widgetheader.html',
            restrict: 'A',
        };
        return directive;

        function link(scope, element, attrs) {
            attrs.$set('class', 'widget-head');
        }
    });

    controllers.directive('myInput', function () {
        return {
            restrict: 'A',
            link: function (scope, element) {
                element.bind('click', function (event) {
                    event.stopPropagation();
                });
            }
        };
    });
    
    controllers.directive('field', function($compile, $http, $templateCache, $interpolate) {
        var templatePath = 'app/template/'; //should be something like '/views/templates/'
        var findInputElement = function(element) {
          return angular.element(element.find('input')[0] || element.find('textarea')[0] || element.find('select')[0]);
        };

        return {
          restrict:'E',
          priority: 100,        // We need this directive to happen before ng-model
          terminal: true,       // We are going to deal with this element
          require: '?^form',    // If we are in a form then we can access the ngModelController
          compile:function compile(element, attrs) {

            // Find all the <validator> child elements and extract their validation message info
            var validationMessages = [];
            angular.forEach(element.find('validator'), function(validatorElement) {
              validatorElement = angular.element(validatorElement);
              validationMessages.push({
                key: validatorElement.attr('key'),
                getMessage: $interpolate(validatorElement.text())
              });
            });

            // Find the content that will go into the new label
            var labelContent = '';
            if ( element.attr('label') ) {
              labelContent = element.attr('label');
              element[0].removeAttribute('label');
            }
            if ( element.find('label')[0] ) {
              labelContent = element.find('label').html();
            }
            if ( !labelContent ) {
              throw new Error('No label provided');
            }

            // Load up the template for this kind of field
            var template = attrs.template || 'input';   // Default to the simple input if none given
            var getFieldElement = $http.get(templatePath + template + '.html', {cache:$templateCache}).then(function(response) {
              var newElement = angular.element(response.data);
              var inputElement = findInputElement(newElement);

              // Copy over the attributes to the input element
              // At least the ng-model attribute must be copied because we can't use interpolation in the template
              angular.forEach(element[0].attributes, function (attribute) {
                var value = attribute.value;
                var key = attribute.name;
                inputElement.attr(key, value);
              });

              // Update the label's contents
              var labelElement = newElement.find('label');
              labelElement.html(labelContent);

              return newElement;
            });

            return function (scope, element, attrs, formController) {
              // We have to wait for the field element template to be loaded
              getFieldElement.then(function(newElement) {
                // Our template will have its own child scope
                var childScope = scope.$new();

                // Generate an id for the input from the ng-model expression
                // (we need to replace dots with something to work with browsers and also form scope)
                // (We couldn't do this in the compile function as we need the scope to
                // be able to calculate the unique id)
                childScope.$modelId = attrs.ngModel.replace('.', '_').toLowerCase() + '_' + childScope.$id;

                // Wire up the input (id and name) and its label (for)
                // (We need to set the input element's name here before we compile.
                // If we leave it to interpolation, the formController doesn't pick it up)
                var inputElement = findInputElement(newElement);
                inputElement.attr('name', childScope.$modelId);
                inputElement.attr('id', childScope.$modelId);
                newElement.find('label').attr('for', childScope.$modelId);

                // TODO: Consider moving this validator stuff into its own directive
                // and use a directive controller to wire it all up
                childScope.$validationMessages = {};
                angular.forEach(validationMessages, function(validationMessage) {
                  // We need to watch incase it has interpolated values that need processing
                  scope.$watch(validationMessage.getMessage, function (message) {
                    childScope.$validationMessages[validationMessage.key] = message;
                  });
                });

                // We must compile our new element in the postLink function rather than in the compile function
                // (i.e. after any parent form element has been linked)
                // otherwise the new input won't pick up the FormController
                $compile(newElement)(childScope, function(clone) {
                  // Place our new element after the original element
                  element.after(clone);
                  // Remove our original element
                  element.remove();
                });

                // Only after the new element has been compiled do we have access to the ngModelController
                // (i.e. formController[childScope.name])
                if ( formController ) {
                  childScope.$form = formController;
                  childScope.$field = formController[childScope.$modelId];
                }
              });
            };
          }
        };
      });
    
    controllers.directive('submitValid', function($parse) {
        return {
          require: 'form',
          link: function(scope, formElement, attributes, form) {
            form.attempt = false;
            formElement.bind('submit', function (event) {
              form.attempt = true;
              if (!scope.$$phase) scope.$apply();

              var fn = $parse(attributes.submitValid);

              if (form.$valid) {
                scope.$apply(function() {
                  fn(scope, {$event:event});
                });
              }
            });
          }
        };
      });

    
});


